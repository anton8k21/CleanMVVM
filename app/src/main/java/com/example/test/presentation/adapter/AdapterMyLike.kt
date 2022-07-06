package com.example.test.homeScreen.presentation.adapter

import android.annotation.SuppressLint
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.test.databinding.ItemLikeByMyBinding
import com.example.test.domain.domainModel.homeScreen.CardBestDomainModel

interface OnInteractionListenerMyLike {
    fun openInfo(){}
    fun likeById(id: Long){}
    fun disLike(id:Long){}
}
class AdapterMyLike(
    private val values: List<CardBestDomainModel>,
    private val onInteractionListenerMyLike: OnInteractionListenerMyLike
) : RecyclerView.Adapter<ViewHolderMyLike>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderMyLike {
        val binding = ItemLikeByMyBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolderMyLike(binding,onInteractionListenerMyLike)
    }

    override fun onBindViewHolder(holder: ViewHolderMyLike, position: Int) {
        val cardItem = values[position]
        holder.bind(cardItem)
    }

    override fun getItemCount() = values.size

}

class ViewHolderMyLike(
    private val binding: ItemLikeByMyBinding,
    private val onInteractionListenerMyLike: OnInteractionListenerMyLike
): RecyclerView.ViewHolder(binding.root) {
    @SuppressLint("SetTextI18n")
    fun bind(bestSeller: CardBestDomainModel) {
        binding.apply {
            phonePrise2.text = bestSeller.discountPrice.toString() + "$"
            phonePrise.text = bestSeller.priceWithoutDiscount.toString() + "$"
            namePhone.text = bestSeller.title
            like.isChecked = bestSeller.isFavorite
            root.setOnClickListener {
                onInteractionListenerMyLike.openInfo()
            }
            like.setOnClickListener {
                if (bestSeller.isFavorite)
                    onInteractionListenerMyLike.disLike(id = bestSeller.id)
                else
                    onInteractionListenerMyLike.likeById(bestSeller.id)
            }
            Glide
                .with(binding.root.context)
                .load(bestSeller.picture)
                .into(phoneImage)


        }
    }
}