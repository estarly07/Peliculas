package com.estarly.peliculas.ui.avatars

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.estarly.peliculas.R
import com.estarly.peliculas.databinding.FragmentAvatarsBinding
import com.estarly.peliculas.ui.adapters.AvatarAdapter
import com.estarly.peliculas.utils.showToast
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AvatarsFragment : Fragment() {
    private          val avatarsViewModel : AvatarsViewModel by viewModels()
    private lateinit var avatarBinding    : FragmentAvatarsBinding
    private          val avatarAdapter    = AvatarAdapter()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        avatarBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_avatars, container, false)
        return avatarBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        avatarBinding.recyclerAvatar.setHasFixedSize(true)
        avatarBinding.recyclerAvatar.layoutManager = GridLayoutManager(context,2)
        avatarAdapter.setListAvatar(avatarsViewModel.getAvatars())
        avatarAdapter.setClick(object : AvatarAdapter.Click{
            override fun onClick(avatar: Int, view: View) {
                avatarsViewModel.chooseAvatar(avatar)
                getString(R.string.choose_avatar).showToast(requireContext())
            }
        })
        
        avatarBinding.recyclerAvatar.adapter = avatarAdapter
    }
}