package com.estarly.peliculas.ui.listMovies

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.NestedScrollView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.estarly.peliculas.MainActivity
import com.estarly.peliculas.R
import com.estarly.peliculas.databinding.FragmentAboutMovieBinding
import com.estarly.peliculas.databinding.FragmentListMoviesBinding
import com.estarly.peliculas.domain.models.Movie
import com.estarly.peliculas.ui.aboutMovie.AboutMovieFragment
import com.estarly.peliculas.ui.adapters.MovieAdapter
import com.estarly.peliculas.utils.listenerScroll


class ListMoviesFragment : Fragment() {

    companion object {
        lateinit var navigation: (page: String) -> Unit
    }

    private lateinit var listBinding    : FragmentListMoviesBinding
    private          val listModel      : ListViewModel by viewModels()
    private          var adapterMovie   : MovieAdapter = MovieAdapter()
    private          var adapterUpcoming: MovieAdapter = MovieAdapter()

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
        listeners()
        startObservers()
        getters()
    }

    private fun getters() {
        listModel.getMovies       ()
        listModel.getMovieLatest  ()
        listModel.getMovieUpcoming()
    }


    private fun startObservers() {
        listBinding.home.scrollHome.listenerScroll { MainActivity.callback.invoke(it) }
        listModel.listMovies.observe(viewLifecycleOwner,{ list->
            adapterMovie.setListMovies(list)
            listBinding.home.recyclerMoviesPopular.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
            listBinding.home.recyclerMoviesPopular.setHasFixedSize(true)
            listBinding.home.recyclerMoviesPopular.adapter = adapterMovie
        })
        listModel.listMoviesUpcoming.observe(viewLifecycleOwner,{ list->
            adapterUpcoming.setListMovies(list)
            listBinding.home.recyclerMovies.layoutManager = GridLayoutManager(context,3)
            listBinding.home.recyclerMovies.setHasFixedSize(true)
            listBinding.home.recyclerMovies.isNestedScrollingEnabled = true

            listBinding.home.recyclerMovies.adapter = adapterUpcoming
        })
        listModel.listMoviesFavorites.observe(viewLifecycleOwner,{ list->
            println(list)
        })
        listModel.movieLatest.observe(viewLifecycleOwner,{ movie->
            Glide.with(context)
                .load("https://image.tmdb.org/t/p/w500${movie.posterPath}")
                .placeholder(R.drawable.defect_one)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(  listBinding.home.imgMovieLatest)

        })
    }

    private fun listeners() {
        navigation = {
            if (it == "HOME") {
                listBinding.home.root.visibility = View.VISIBLE
                listBinding.favorites.visibility = View.GONE
            } else {
                listBinding.home.root.visibility = View.GONE
                listBinding.favorites.visibility = View.VISIBLE
            }
        }
        adapterMovie   .listenerMovieAdapter()
        adapterUpcoming.listenerMovieAdapter()
    }
    private fun MovieAdapter.listenerMovieAdapter() =
        this.setClick(object:MovieAdapter.Click{
            override fun onClick(movie: Movie, view: View) {
                AboutMovieFragment.setMovie( movie)
                MainActivity.callback(false)
                NavHostFragment.findNavController(this@ListMoviesFragment).navigate(R.id.listMovies_to_aboutMovie)
            }
        })
}