package com.estarly.peliculas.data.sharedPreferences

import android.content.Context

class SharedPreferences(var context: Context) {
    private val avatar = "AVATAR"
    fun getAvatar():Int{
        val sharedPreferences = context.getSharedPreferences(avatar,Context.MODE_PRIVATE)
        return sharedPreferences.getInt(avatar,-1)
    }
    fun chooseAvatar(avatar:Int){
        val sharedPreferences = context.getSharedPreferences(this.avatar,Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putInt(this.avatar,avatar)
        editor.commit()
    }

}