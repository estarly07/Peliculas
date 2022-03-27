package com.estarly.peliculas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import androidx.databinding.DataBindingUtil
import com.estarly.peliculas.databinding.ActivityMainBinding
import com.estarly.peliculas.ui.listMovies.ListMoviesFragment
import com.estarly.peliculas.utils.animTranslateToBottomOrUp

class MainActivity : AppCompatActivity() {
    private lateinit var mainBinding: ActivityMainBinding
    companion object{
        lateinit var callback       :(isUp:Boolean)->Unit
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        activeButtonsBar()
        activeListenerNavigationBar()
    }

    private fun activeListenerNavigationBar() {
        callback = {
            mainBinding.navigatorBar.animTranslateToBottomOrUp(
                isUp     = it,
                duration = 200L
            )
        }

    }

    private fun activeButtonsBar(){
        mainBinding.btnHome.setOnClickListener {
            ListMoviesFragment.navigation(ListMoviesFragment.Pages.HOME)
        }
        mainBinding.btnFavorites.setOnClickListener {
            ListMoviesFragment.navigation(ListMoviesFragment.Pages.FAVORITES)
        }
    }


}