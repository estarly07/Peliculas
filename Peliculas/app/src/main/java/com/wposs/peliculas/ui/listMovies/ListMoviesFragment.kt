package com.wposs.peliculas.ui.listMovies

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.NavHostFragment
import com.wposs.peliculas.R
import com.wposs.peliculas.databinding.FragmentListMoviesBinding


class ListMoviesFragment : Fragment() {

    companion object {
        lateinit var navigation: (page: String) -> Unit
    }

    private lateinit var listBinding: FragmentListMoviesBinding
    private          val listModel  : ListViewModel by viewModels()

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
        listModel.getMovies()

    }

    private fun startObservers() {
        listModel.listMovies.observe(viewLifecycleOwner,{ list->
            println(list)
        })
        listModel.listMoviesFavorites.observe(viewLifecycleOwner,{ list->
            println(list)
        })
    }

    private fun listeners() {
        navigation = {
            if (it == "HOME") {
                listBinding.home.visibility = View.VISIBLE
                listBinding.favorites.visibility = View.GONE
            } else {
                listBinding.home.visibility = View.GONE
                listBinding.favorites.visibility = View.VISIBLE
            }
        }
    }

}