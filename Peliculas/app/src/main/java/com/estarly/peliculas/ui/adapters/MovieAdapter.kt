package com.estarly.peliculas.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.estarly.peliculas.R
import com.estarly.peliculas.databinding.ItemMovieBinding
import com.estarly.peliculas.domain.models.Movie

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {
    private lateinit var listMovies: List<Movie>

    fun setListMovies(list: List<Movie>) {
        listMovies = list
    }

    interface Click {
        fun onClick(movie: Movie, view: View)
    }

    private lateinit var click: Click
    fun setClick(click: Click) {
        this.click = click
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val movieDataBinding =
            DataBindingUtil.inflate<ItemMovieBinding>(inflater, R.layout.item_movie, parent, false)
        return ViewHolder(movieDataBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(holder.itemView.context)
            .load("https://image.tmdb.org/t/p/w500${listMovies[position].poster_path}")
            .error(R.drawable.no_found)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(holder.movieBinding.imgMovie)
        holder.itemView.setOnClickListener {
            click.onClick(
                movie = listMovies[position],
                view  = it
            )
        }
    }

    override fun getItemCount(): Int = listMovies.size
    class ViewHolder(var movieBinding: ItemMovieBinding) :
        RecyclerView.ViewHolder(movieBinding.root)
}
