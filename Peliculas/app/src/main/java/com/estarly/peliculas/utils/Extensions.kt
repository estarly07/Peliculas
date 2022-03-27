package com.estarly.peliculas.utils

import android.content.Context
import android.view.Surface
import android.view.WindowManager
import androidx.core.widget.NestedScrollView

fun NestedScrollView.listenerScroll(callback: (isUp:Boolean ) -> Unit) {
    this.setOnScrollChangeListener(NestedScrollView.OnScrollChangeListener { v, scrollX, scrollY, oldScrollX, oldScrollY ->
        callback.invoke(scrollY < oldScrollY)
    })
}
/**
 * return true  => Vertical
 *        false => Horizontal
 */
fun Context.getTypeRotation():Boolean =
    when((getSystemService(Context.WINDOW_SERVICE)as WindowManager).defaultDisplay.orientation){
        Surface.ROTATION_0,Surface.ROTATION_180-> true
        else->false
    }
