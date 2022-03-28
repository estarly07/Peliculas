package com.estarly.peliculas.ui.avatars

import androidx.lifecycle.ViewModel
import com.estarly.peliculas.data.sharedPreferences.SharedPreferences
import com.estarly.peliculas.utils.GlobalUtils
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AvatarsViewModel @Inject constructor(
    private var sharedPreferences: SharedPreferences
) : ViewModel() {

    fun getAvatars():List<Int> = GlobalUtils.avatars

    /**
     * Guardar el avatar que escogio el usuario
     */
    fun chooseAvatar(avatar : Int){
        sharedPreferences.chooseAvatar(avatar)
    }

}