package com.estarly.peliculas.utils

import androidx.core.widget.NestedScrollView

fun NestedScrollView.listenerScroll(callback: (isUp:Boolean ) -> Unit) {
    this.setOnScrollChangeListener(NestedScrollView.OnScrollChangeListener { v, scrollX, scrollY, oldScrollX, oldScrollY ->
        callback.invoke(scrollY < oldScrollY)
    })
}