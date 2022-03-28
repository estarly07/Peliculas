package com.estarly.peliculas.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.estarly.peliculas.R
import com.estarly.peliculas.databinding.ItemAvatarBinding
import com.estarly.peliculas.databinding.ItemMovieBinding
import com.estarly.peliculas.domain.models.Movie

class AvatarAdapter : RecyclerView.Adapter<AvatarAdapter.ViewHolder>() {
    private lateinit var listAvatar: List<Int>

    fun setListAvatar(list: List<Int>) {
        listAvatar = list
    }

    interface Click {
        fun onClick(avatar: Int, view: View)
    }

    private lateinit var click: Click
    fun setClick(click: Click) {
        this.click = click
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val movieDataBinding =
            DataBindingUtil.inflate<ItemAvatarBinding>(inflater, R.layout.item_avatar, parent, false)
        return ViewHolder(movieDataBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(holder.itemView.context)
            .load(listAvatar[position])
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(holder.avatarBinding.imgAvatar)
        holder.itemView.setOnClickListener {
            click.onClick(
                avatar = listAvatar[position],
                view  = it
            )
        }
    }

    override fun getItemCount(): Int = listAvatar.size
    class ViewHolder(var avatarBinding: ItemAvatarBinding) :
        RecyclerView.ViewHolder(avatarBinding.root)
}
