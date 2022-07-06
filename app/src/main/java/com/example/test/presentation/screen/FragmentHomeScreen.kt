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
import com.example.test.R
import com.example.test.databinding.FragmentFilterOptionsItemBinding
import com.example.test.databinding.FragmentHomeScreenBinding
import com.example.test.homeScreen.presentation.adapter.AdapterHomeCarousel
import com.example.test.homeScreen.presentation.adapter.AdapterHomeScreen
import com.example.test.homeScreen.presentation.adapter.OnInteractionListener
import com.example.test.presentation.viewModel.ViewModelHomeScreen
import com.google.android.material.bottomsheet.BottomSheetDialog

class FragmentHomeScreen : Fragment() {
    private val viewModel: ViewModelHomeScreen by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentHomeScreenBinding.inflate(layoutInflater)

        val recyclerView =
            binding.root.findViewById(R.id.list) as RecyclerView
        recyclerView.layoutManager = GridLayoutManager(context, 2)



        viewModel.dataBest.observe(viewLifecycleOwner){
            val adapterRecyclerView =
                AdapterHomeScreen(it, object : OnInteractionListener {
                    override fun openInfo() {
                        findNavController().navigate(R.id.action_homeScreen_to_fragmentInfo)
                    }

                    override fun likeById(id: Long) {
                        viewModel.like(id)
                    }

                    override fun disLike(id: Long) {
                        viewModel.disLike(id)
                    }
                })

            binding.list.adapter = adapterRecyclerView
        }


        viewModel.data.observe(viewLifecycleOwner) {
            val adapterCarousel = AdapterHomeCarousel(it.homeStore)
            binding.constraint2.adapter = adapterCarousel


        }

        binding.apply {
            bottomNavigation.setOnItemSelectedListener { item ->
                when (item.itemId) {
                    R.id.my_cart -> {
                        findNavController().navigate(R.id.action_homeScreen_to_myCard)
                        true
                    }
                    R.id.list_is_like -> {
                        findNavController().navigate(R.id.action_homeScreen_to_fragmentMyLikePhone)
                        true
                    }
                    else -> false
                }
            }

            buttonCategoryPhone.setOnClickListener {
                buttonCategoryBooks.isChecked = false
                buttonCategoryComputer.isChecked = false
                buttonCategoryHealth.isChecked = false
            }

            buttonCategoryComputer.setOnClickListener {
                buttonCategoryBooks.isChecked = false
                buttonCategoryPhone.isChecked = false
                buttonCategoryHealth.isChecked = false
            }

            buttonCategoryHealth.setOnClickListener {
                buttonCategoryBooks.isChecked = false
                buttonCategoryComputer.isChecked = false
                buttonCategoryPhone.isChecked = false
            }

            buttonCategoryBooks.setOnClickListener {
                buttonCategoryPhone.isChecked = false
                buttonCategoryComputer.isChecked = false
                buttonCategoryHealth.isChecked = false
            }



            filter.setOnClickListener {
                val bindingDialog =
                    FragmentFilterOptionsItemBinding.inflate(layoutInflater)
                val bottomSheetDialog =
                    BottomSheetDialog(binding.root.context, R.style.BottomSheetDialog)
                val bottomSheetDialogView: View =
                    bindingDialog.bottomDialog

                bottomSheetDialog.setContentView(bottomSheetDialogView)
                bottomSheetDialog.show()

                bindingDialog.closeFilter.setOnClickListener {
                    bottomSheetDialog.dismiss()
                }
            }
        }
        return binding.root
    }
}