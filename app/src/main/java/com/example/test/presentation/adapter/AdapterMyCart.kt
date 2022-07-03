package com.example.test.myCartScreen

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.test.databinding.RecycleItemMyCardBinding
import com.example.test.data.dataModel.myCartScreen.BasketDataModel
import com.example.test.data.dataModel.myCartScreen.BasketDomainModel


class AdapterMyCart(
    private val value: List<BasketDomainModel>
): RecyclerView.Adapter<ViewHolderMyCard>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderMyCard {
        val binding = RecycleItemMyCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolderMyCard(binding)
    }

    override fun onBindViewHolder(holder: ViewHolderMyCard, position: Int) {
        val itemMyCard = value[position]
        holder.bind(itemMyCard)
    }

    override fun getItemCount():Int = value.size
}

class ViewHolderMyCard(
    private val binding: RecycleItemMyCardBinding
): RecyclerView.ViewHolder(binding.root){
    @SuppressLint("SetTextI18n")
    fun bind(basket: BasketDomainModel){
        binding.apply {
            title.text = basket.title
            phonePrise.text = "$" + basket.price.toString()
            Glide
                .with(root.context)
                .load(basket.images)
                .into(imagesPhone)
        }

    }

}