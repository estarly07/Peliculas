package com.estarly.peliculas.ui.listMovies

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.estarly.peliculas.MainActivity
import com.estarly.peliculas.R
import com.estarly.peliculas.databinding.FragmentListMoviesBinding
import com.estarly.peliculas.domain.models.Movie
import com.estarly.peliculas.ui.aboutMovie.AboutMovieFragment
import com.estarly.peliculas.ui.adapters.MovieAdapter
import com.estarly.peliculas.utils.getTypeRotation
import com.estarly.peliculas.utils.listenerScroll


class ListMoviesFragment : Fragment() {
    enum class Pages{
        HOME,FAVORITES
    }
    private var page:Pages = Pages.HOME
    companion object {
        lateinit var navigation: (page: Pages) -> Unit
    }

    private lateinit var listBinding    : FragmentListMoviesBinding
    private          val listModel      : ListViewModel by viewModels()
    private          var adapterMovie   : MovieAdapter = MovieAdapter()
    private          var adapterUpcoming: MovieAdapter = MovieAdapter()
    private          var adapterFavorite: MovieAdapter = MovieAdapter()
    private          var vanishHandling = 0 //contador que aumentara cada vez que se finalice cada llamado de cada tipo de lista (popular,proximo)
    private          var appearWarning  = 0 //contador que aumentara cada vez que se finalice cada llamado de cada tipo de lista (popular,proximo)
    private          var bothListEmpty  = mutableListOf(false,false)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        listBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_list_movies,
            container,
            false
        )
        return listBinding.root
    }

    override fun onResume() {
        super.onResume()
        MainActivity.callback(true)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listModel.initUsecase(requireContext())
        listBinding.favorites.noFound.title ="Aun no tienes películas \nfavoritas"
        initAttributesRecycler()
        listeners()
        startObservers()
        getters()
    }

    private fun initAttributesRecycler() {
        listBinding.home.recyclerMovies              .initRecycler(GridLayoutManager(context,  if (context!!.getTypeRotation()) 3 else 4))
        listBinding.favorites.recyclerMoviesFavorites.initRecycler(GridLayoutManager(context,  if (context!!.getTypeRotation()) 3 else 4))
        listBinding.home.recyclerMoviesPopular       .initRecycler(LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false),enabledScroll = false)
    }

    private fun RecyclerView.initRecycler(layoutManager : RecyclerView.LayoutManager,enabledScroll:Boolean = true) {
       this.setHasFixedSize(true)
       this.isNestedScrollingEnabled = enabledScroll
       this.layoutManager = layoutManager
    }
    /**
     * Obtener la informacion del api
     */
    private fun getters() {
        listBinding.handling.visibility  = View.VISIBLE
        listBinding.home.isEmptyPopular  = true
        listBinding.home.isEmptyUpcoming = true
        listBinding.home.noFound.root.visibility = View.GONE

        listModel.getMovieLatest    ()

        listModel.getMovies         ()
        listModel.getMovieUpcoming  ()
    }

    private fun startObservers() {
        listBinding.home.scrollHome.listenerScroll { MainActivity.callback.invoke(it) }
        listModel.listMovies.observe(viewLifecycleOwner,{ list->
            vanishHandling += 1
            appearWarning  += 1
            bothListEmpty[0] = list.isEmpty()
            vanishHandling(list.isEmpty())
            appearWarning()
            listBinding.home.isEmptyPopular = list.isEmpty()

            adapterMovie.setListMovies(list)
            listBinding.home.recyclerMoviesPopular.adapter = adapterMovie
        })
        listModel.listMoviesUpcoming.observe(viewLifecycleOwner,{ list->
            vanishHandling += 1
            appearWarning  += 1
            bothListEmpty[1] = list.isEmpty()
            vanishHandling(list.isEmpty())
            appearWarning()
            listBinding.home.isEmptyUpcoming = list.isEmpty()

            adapterUpcoming.setListMovies(list)
            listBinding.home.recyclerMovies.adapter = adapterUpcoming
        })
        listModel.listMoviesFavorites.observe(viewLifecycleOwner,{ list->
            listBinding.handling.visibility = View.GONE
            listBinding.favorites.recyclerMoviesFavorites.visibility = View.VISIBLE
            if (list.isEmpty()) {
                listBinding.favorites.noFound.root.visibility = View.VISIBLE
            }
            adapterFavorite.setListMovies(list)
            listBinding.favorites.recyclerMoviesFavorites.adapter = adapterFavorite
        })

        listModel.movieLatest.observe(viewLifecycleOwner,{ movie->
            Glide.with(context)
                .load("https://image.tmdb.org/t/p/w500${movie?.poster_path}")
                .placeholder(R.drawable.defect_one)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(  listBinding.home.imgMovieLatest)
        })
    }

    /**
     * Iniciar todos las lambdas como el de navegacion, click en los items de las listas etc
     */
    private fun listeners() {
        navigation = {
            page   = it
            listBinding.layout.scheduleLayoutAnimation()
            listBinding.page = it

            if(page == Pages.FAVORITES){
                listBinding.handling.visibility = View.VISIBLE
                listBinding.favorites.noFound.root.visibility = View.GONE
                listModel.getMoviesFavorites()}
        }
        listBinding.home.noFound.title ="No se pudo obtener peliculas\n\ntoca el TV para \nintertar otra vez"
        listBinding.home.noFound.root.setOnClickListener {
            getters()
        }
        navigation(Pages.HOME)
        adapterMovie   .listenerMovieAdapter()
        adapterUpcoming.listenerMovieAdapter()
        adapterFavorite.listenerMovieAdapter()
    }

    /**
     * Funcion de clic en cada iteme de las listas
     */
    private fun MovieAdapter.listenerMovieAdapter() =
        this.setClick(object:MovieAdapter.Click{
            override fun onClick(movie: Movie, view: View) {
                AboutMovieFragment.setMovie( movie)
                MainActivity.callback(false)
                NavHostFragment.findNavController(this@ListMoviesFragment).navigate(R.id.listMovies_to_aboutMovie)
            }
        })

    /**
     * Devanecer el handling cuando termine los dos llamados de las dos listas
     * o si un llamado termino y no esta vacio
     */
    private fun vanishHandling(isEmptyList :Boolean) {
        if(vanishHandling ==2 || !isEmptyList){
            listBinding.handling.visibility = View.GONE
            vanishHandling = 0
        }
    }
    /**
     * Devanecer el warning cuando termine los dos llamados de las dos listas y estan vacias
     */
    private fun appearWarning(){
        if(appearWarning == 2 && !bothListEmpty.contains(false)){
            listBinding.home.noFound.title ="No se pudo obtener peliculas\n\ntoca el TV para \nintertar otra vez"
            listBinding.home.noFound.root.visibility = View.VISIBLE
            bothListEmpty[0] = false
            bothListEmpty[1] = false
            appearWarning    = 0
        }
    }
}