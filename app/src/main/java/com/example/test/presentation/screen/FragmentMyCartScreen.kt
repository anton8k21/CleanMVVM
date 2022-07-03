package com.example.test.presentation.screen

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.test.R
import com.example.test.databinding.FragmentMyCartScreenBinding
import com.example.test.myCartScreen.AdapterMyCart
import com.example.test.presentation.viewModel.ViewModelMyCartScreen

class FragmentMyCartScreen : Fragment() {
    val viewModel: ViewModelMyCartScreen by activityViewModels()

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentMyCartScreenBinding.inflate(layoutInflater)

        val recyclerView =
            binding.root.findViewById(R.id.list) as RecyclerView
        recyclerView.layoutManager = GridLayoutManager(context, 1)


        viewModel.data.observe(viewLifecycleOwner) {
            val adapterCarousel = AdapterMyCart(it.basket)
            binding.apply {
                list.adapter = adapterCarousel
                totalValue.text = "$" + it.total.toString()
                deliveryValue.text = it.delivery
            }
        }

        binding.closeMyCart.setOnClickListener {
            findNavController().navigateUp()
        }
        return binding.root
    }
}