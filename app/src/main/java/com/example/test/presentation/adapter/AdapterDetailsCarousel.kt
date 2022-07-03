package com.example.test.detailsScreen

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.test.databinding.CarouselDetailsScreenItemBinding

class AdapterDetailsCarousel(
    private val listImage: List<String>
): RecyclerView.Adapter<ViewHolderInfo>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderInfo {
        val binding = CarouselDetailsScreenItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolderInfo(binding)
    }

    override fun onBindViewHolder(holder: ViewHolderInfo, position: Int) {
        val item = listImage[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = listImage.size
}

class ViewHolderInfo(
   private val binding: CarouselDetailsScreenItemBinding
):RecyclerView.ViewHolder(binding.root){
    fun bind(imageUrl: String){
        binding.apply {
            Glide
                .with(root.context)
                .load(imageUrl)
                .into(phoneImage)
        }


    }

}