package com.example.test.presentation.screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.test.R
import com.example.test.databinding.FragmentMyLikePhoneBinding
import com.example.test.homeScreen.presentation.adapter.AdapterMyLike
import com.example.test.homeScreen.presentation.adapter.OnInteractionListener
import com.example.test.homeScreen.presentation.adapter.OnInteractionListenerMyLike

import com.example.test.myCartScreen.AdapterMyCart
import com.example.test.presentation.viewModel.ViewModelHomeScreen
import com.example.test.presentation.viewModel.ViewModelMyCartScreen
import com.example.test.presentation.viewModel.ViewModelMyLikePhone
import kotlinx.android.synthetic.main.recycle_item_my_card.*

class FragmentMyLikePhone: Fragment() {
    private val viewModel: ViewModelMyLikePhone by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentMyLikePhoneBinding.inflate(layoutInflater)

        val recyclerView =
            binding.root.findViewById(R.id.list) as RecyclerView
        recyclerView.layoutManager = GridLayoutManager(context, 1)


        viewModel.data.observe(viewLifecycleOwner) {
            val adapterMyLike = AdapterMyLike(it, object : OnInteractionListenerMyLike {
                override fun openInfo() {
                    findNavController().navigate(R.id.action_fragmentMyLikePhone_to_fragmentInfo)
                }

                override fun likeById(id: Long) {
                    viewModel.like(id)
                }

                override fun disLike(id: Long) {
                    viewModel.disLike(id)
                }
            })
            binding.apply {
                list.adapter = adapterMyLike
                closeMyCart.setOnClickListener {
                    findNavController().navigateUp()
                }
            }
        }

        return binding.root
    }
}