package com.estarly.peliculas.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.estarly.peliculas.R
import com.estarly.peliculas.databinding.ItemMovieBinding

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {
    private lateinit var listMovies: List<String>

    fun setListMovies(list: List<String>) {
        listMovies = list
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val movieDataBinding =
            DataBindingUtil.inflate<ItemMovieBinding>(inflater, R.layout.item_movie, parent, false)
        return ViewHolder(movieDataBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    }

    override fun getItemCount(): Int = listMovies.size
    class ViewHolder(movieBinding: ItemMovieBinding) : RecyclerView.ViewHolder(movieBinding.root)
}
