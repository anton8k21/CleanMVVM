package com.example.test.homeScreen.presentation.adapter

import android.annotation.SuppressLint
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.test.databinding.RecycleItemHomeBinding
import com.example.test.domain.domainModel.homeScreen.CardBestDomainModel

interface OnInteractionListener {
    fun openInfo(){}
    fun likeById(id: Long){}
    fun disLike(id:Long){}
}
class AdapterHomeScreen(
    private val values: List<CardBestDomainModel>,
    private val onInteractionListener: OnInteractionListener
) : RecyclerView.Adapter<ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = RecycleItemHomeBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding,onInteractionListener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val cardItem = values[position]
        holder.bind(cardItem)
    }

    override fun getItemCount() = values.size

}

class ViewHolder(
    private val binding: RecycleItemHomeBinding,
    private val onInteractionListener: OnInteractionListener
): RecyclerView.ViewHolder(binding.root) {
    @SuppressLint("SetTextI18n")
    fun bind(bestSeller: CardBestDomainModel) {
        binding.apply {
            phonePrise2.text = bestSeller.discountPrice.toString() + "$"
            phonePrise.text = bestSeller.priceWithoutDiscount.toString() + "$"
            namePhone.text = bestSeller.title
            like.isChecked = bestSeller.isFavorite
            Glide
                .with(binding.root.context)
                .load(bestSeller.picture)
                .into(phoneImage)
            root.setOnClickListener {
                onInteractionListener.openInfo()
            }
            like.setOnClickListener {
                if (bestSeller.isFavorite)
                    onInteractionListener.disLike(id = bestSeller.id)
                else
                onInteractionListener.likeById(bestSeller.id)
            }


        }
    }
}