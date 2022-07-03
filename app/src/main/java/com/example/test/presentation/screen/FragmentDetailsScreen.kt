package com.example.test.presentation.screen

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.test.databinding.FragmentDetailsScreenBinding
import com.example.test.detailsScreen.AdapterDetailsCarousel
import com.example.test.detailsScreen.presentation.ViewModelDetailsScreen

class FragmentDetailsScreen: Fragment() {
    val viewModel: ViewModelDetailsScreen by activityViewModels()

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentDetailsScreenBinding.inflate(layoutInflater)

        viewModel.data.observe(viewLifecycleOwner){
            val adapter = AdapterDetailsCarousel(it.images)
            binding.apply {
                camera.text = it.camera
                cpu.text = it.CPU
                sd.text = it.sd
                ssd.text = it.ssd
                title.text = it.title
                viewPager2.adapter = adapter
                addToCart.text = "Add to Cart        " + it.price.toString() + "$"
                star1.isVisible = it.rating >= 1
                star2.isVisible = it.rating >= 2
                star3.isVisible = it.rating >= 3
                star4.isVisible = it.rating >= 4
                star5.isVisible = it.rating >= 5
            }
        }
        return binding.root
    }
}