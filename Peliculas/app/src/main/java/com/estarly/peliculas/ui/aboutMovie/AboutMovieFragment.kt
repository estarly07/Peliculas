package com.estarly.peliculas.ui.aboutMovie

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.estarly.peliculas.R
import com.estarly.peliculas.databinding.FragmentAboutMovieBinding
import com.estarly.peliculas.databinding.FragmentListMoviesBinding
import com.estarly.peliculas.domain.models.Movie
import com.estarly.peliculas.ui.adapters.MovieAdapter
import com.estarly.peliculas.ui.listMovies.ListMoviesFragment
import com.estarly.peliculas.ui.listMovies.ListViewModel


class AboutMovieFragment : Fragment() {
    private lateinit var aboutBinding : FragmentAboutMovieBinding
    private          val aboutModel   : AboutViewModel by viewModels()
    private          val adapterMovie = MovieAdapter()
    companion object {
        private lateinit var movie: Movie
        fun setMovie(movie: Movie) {
            this.movie = movie
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        aboutBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_about_movie, container, false)
        return aboutBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        aboutBinding.wait = false
        aboutBinding.movie = movie

        adapterMovie.setClick(object : MovieAdapter.Click{
            override fun onClick(movie: Movie, view: View) {
                aboutBinding.wait = true
                AboutMovieFragment.movie = movie
                aboutBinding.movie       = movie
                getData()
            }

        })

        getData()
        aboutModel.listMoviesSimilar.observe(viewLifecycleOwner,{list->
            adapterMovie.setListMovies(list)
            aboutBinding.recyclerMoviesSimilar.layoutManager = GridLayoutManager(context,3)
            aboutBinding.recyclerMoviesSimilar.setHasFixedSize(true)
            aboutBinding.recyclerMoviesSimilar.isNestedScrollingEnabled = true

            aboutBinding.recyclerMoviesSimilar.adapter = adapterMovie
            aboutBinding.wait = false
        })
    }

    private fun getData() {
        Glide.with(context)
            .load("https://image.tmdb.org/t/p/w500${movie.posterPath}")
            .error(R.drawable.no_found)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(aboutBinding.imgMovie)
        aboutModel.getMoviesSimilar(movie.id.toString())
    }

}