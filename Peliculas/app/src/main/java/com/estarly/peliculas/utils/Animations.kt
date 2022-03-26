package com.estarly.peliculas.utils

import android.view.View

/**EXTENSION PARA MOVER ASIA ARRIBA O ABAJO  UNA VIEW CON UNA ANIMACIÓN
 * @param isUp      true => Mover  arriba false => Mover  abajo
 * @param duration  duracion de cuanto tiempo va a tardar la animacion
 * */
fun View.animTranslateToBottomOrUp(isUp: Boolean, duration: Long) {
    val moveY = if (isUp)  0  else  this.height * 2
    this.animate().setStartDelay(0).setDuration(duration).translationY(moveY.toFloat()).start()
}
