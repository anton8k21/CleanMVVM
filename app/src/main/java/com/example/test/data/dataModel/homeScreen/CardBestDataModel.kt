package com.example.test.data.dataModel.homeScreen

import com.example.test.domain.domainModel.homeScreen.CardBestDomainModel
import com.google.gson.annotations.SerializedName

data class CardBestDataModel(
    val id: Long,
    val isFavorite: Boolean,
    val title: String,
    @SerializedName("price_without_discount")
    val priceWithoutDiscount: Int,
    @SerializedName("discount_price")
    val discountPrice: Int,
    val picture: String
) {

    fun toCardBestDomainModel(): CardBestDomainModel{
        val value = CardBestDomainModel(
            id = id,
            isFavorite = isFavorite,
            title = title,
            priceWithoutDiscount = priceWithoutDiscount,
            discountPrice = discountPrice,
            picture = picture
        )
        return value
    }
}