package com.wposs.peliculas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.wposs.peliculas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var mainBinding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

    }

    fun activeButtonsBar(){
        mainBinding.btnHome.setOnClickListener {

        }
        mainBinding.btnFavorites.setOnClickListener {

        }
    }
}