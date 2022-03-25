package com.wposs.peliculas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.wposs.peliculas.databinding.ActivityMainBinding
import com.wposs.peliculas.ui.aboutMovie.AboutMovieFragment
import com.wposs.peliculas.ui.listMovies.ListMoviesFragment

class MainActivity : AppCompatActivity() {
    lateinit var mainBinding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        activeButtonsBar()
    }

    fun activeButtonsBar(){
        mainBinding.btnHome.setOnClickListener {
            ListMoviesFragment.navigation("HOME")
        }
        mainBinding.btnFavorites.setOnClickListener {
            ListMoviesFragment.navigation("FAVORITE")
        }
    }


}