package com.estarly.peliculas.utils

import android.content.Context
import android.view.View
import android.view.animation.AnimationUtils
import com.estarly.peliculas.R

/**EXTENSION PARA MOVER ASIA ARRIBA O ABAJO  UNA VIEW CON UNA ANIMACIÓN
 * @param isUp      true => Mover  arriba false => Mover  abajo
 * @param duration  duracion de cuanto tiempo va a tardar la animacion
 * */
fun View.animTranslateToBottomOrUp(isUp: Boolean, duration: Long) {
    val moveY = if (isUp)  0  else  this.height * 2
    this.animate().setStartDelay(0).setDuration(duration).translationY(moveY.toFloat()).start()
}
/**EXTENSION PARA MOSTRAR UNA VIEW CON UNA ANIMACIÓN
 * @param context
 * @param duration duracion de cuanto tiempo va a tardar la animacion
 * */
fun View.animAppear(context: Context, duration: Int): Unit {
    val animations      = AnimationUtils.loadAnimation(context, R.anim.anim_appear)
    animations.duration = duration.toLong()

    this.visibility     = View.VISIBLE
    this.animation      = animations
}
/**EXTENSION PARA OCULTAR UNA VIEW CON UNA ANIMACIÓN
 * @param context
 * @param duration duracion de cuanto tiempo va a tardar la animacion
 * */
fun View.animVanish(context: Context, duration: Int): Unit {
    val animations      = AnimationUtils.loadAnimation(context, R.anim.anim_vanish)
    animations.duration = duration.toLong()

    this.visibility     = View.GONE
    this.animation      = animations
}