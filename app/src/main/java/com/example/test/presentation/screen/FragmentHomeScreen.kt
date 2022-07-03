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

class FragmentHomeScreen: Fragment() {
    private val viewModel: ViewModelHomeScreen by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentHomeScreenBinding.inflate(layoutInflater)

        val crimeRecyclerView =
            binding.root.findViewById(R.id.list) as RecyclerView
        crimeRecyclerView.layoutManager = GridLayoutManager(context,2)


        viewModel.data.observe(viewLifecycleOwner) {
            val adapterCarousel = AdapterHomeCarousel(it.homeStore)
            binding.constraint2.adapter = adapterCarousel

            val adapterRecyclerView = AdapterHomeScreen(it.bestSeller, object:OnInteractionListener {
                override fun openInfo() {
                findNavController().navigate(R.id.action_homeScreen_to_fragmentInfo)
                }
            })
            binding.list.adapter = adapterRecyclerView
        }

        binding.apply {
            buttonCategoryPhone.setOnClickListener {
                findNavController().navigate(R.id.action_homeScreen_to_myCard)
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
                val bottomSheetDialog =
                    BottomSheetDialog(binding.root.context, R.style.BottomSheetDialog)
                val bottomSheetDialogView: View =
                    FragmentFilterOptionsItemBinding.inflate(layoutInflater).bottomDialog
                bottomSheetDialog.setContentView(bottomSheetDialogView)
                bottomSheetDialog.show()
            }

        }
        return binding.root
    }
}