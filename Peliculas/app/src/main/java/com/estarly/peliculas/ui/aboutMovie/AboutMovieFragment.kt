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
import com.estarly.peliculas.domain.models.Movie
import com.estarly.peliculas.ui.adapters.MovieAdapter
import com.estarly.peliculas.utils.getTypeRotation
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AboutMovieFragment : Fragment() {
    private lateinit var aboutBinding : FragmentAboutMovieBinding
    private          val aboutModel   : AboutViewModel by viewModels()
    private          val adapterMovie = MovieAdapter()
    private          var isFavorite   = false
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
        aboutBinding.movie = movie
        adapterMovie.setClick(object : MovieAdapter.Click{
            override fun onClick(movie: Movie, view: View) {
                AboutMovieFragment.movie = movie
                aboutBinding.movie       = movie
                getData()
            }
        })

        getData()
        aboutModel.listMoviesSimilar.observe(viewLifecycleOwner,{list->
            aboutBinding.isEmptyList = list.isEmpty()
            adapterMovie.setListMovies(list)
            aboutBinding.recyclerMoviesSimilar.layoutManager = GridLayoutManager(context,
                if (context!!.getTypeRotation()) 3 else 4)
            aboutBinding.recyclerMoviesSimilar.setHasFixedSize(true)
            aboutBinding.recyclerMoviesSimilar.isNestedScrollingEnabled = true

            aboutBinding.recyclerMoviesSimilar.adapter = adapterMovie
        })

        aboutBinding.btnStar.setOnClickListener {
            if (!isFavorite){
                aboutModel.insertMovie(movie)
            }else{
                aboutModel.deleteMovie(movie)
            }
            isFavorite = !isFavorite
            animateStar(isFavorite)
        }
    }

    /**
     * Obtener info de la pelicula seleccionada
     */
    private fun getData() {
        aboutBinding.scroll.post { aboutBinding.scroll.scrollTo(0,  0) }
        Glide.with(context)
            .load("https://image.tmdb.org/t/p/w500${movie.poster_path}")
            .error(R.drawable.no_found)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(aboutBinding.imgMovie)
        aboutModel.getMoviesSimilar(movie.id.toString())
        isFavorite = aboutModel.getMovie(movie.id)
        animateStar(isFavorite)

    }

    /**
     * Animar las estrella de acuerdo si es favorita o no
     * @param isFavorite
     */
    private fun animateStar(isFavorite : Boolean){
        if (isFavorite){
            aboutBinding.star.playAnimation()
        }else{
            aboutBinding.star.progress =0f
            aboutBinding.star.pauseAnimation()
        }
    }
}