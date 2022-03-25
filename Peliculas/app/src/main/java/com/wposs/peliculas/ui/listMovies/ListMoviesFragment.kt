package com.wposs.peliculas.ui.listMovies

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.NavHostFragment
import com.wposs.peliculas.R
import com.wposs.peliculas.databinding.FragmentListMoviesBinding


class ListMoviesFragment : Fragment() {

    companion object {

        lateinit var navigation: (page: String) -> Unit
    }

    private lateinit var listBinding: FragmentListMoviesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        listBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_list_movies, container, false)
        return listBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
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