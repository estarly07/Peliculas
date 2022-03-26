package com.estarly.peliculas.ui.listMovies

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.estarly.peliculas.R
import com.estarly.peliculas.databinding.FragmentListMoviesBinding
import com.estarly.peliculas.ui.adapters.MovieAdapter


class ListMoviesFragment : Fragment() {

    companion object {
        lateinit var navigation: (page: String) -> Unit
    }

    private lateinit var listBinding : FragmentListMoviesBinding
    private          val listModel   : ListViewModel by viewModels()
    private          var adapterMovie: MovieAdapter = MovieAdapter()

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listeners()
        startObservers()
        getters()

    }

    private fun getters() {
        listModel.getMovies()
        listModel.getMovieLatest()
    }

    private fun startObservers() {
        listModel.listMovies.observe(viewLifecycleOwner,{ list->
            adapterMovie.setListMovies(list)
            listBinding.home.recyclerMovies.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
            listBinding.home.recyclerMovies.setHasFixedSize(true)
            listBinding.home.recyclerMovies.adapter = adapterMovie
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
    }

}