package com.example.test.data.dp.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.test.data.dataModel.homeScreen.CardBestDataModel

@Entity
data class CardBestEntity(
    @PrimaryKey
    val id: Long,
    val isFavorite: Boolean,
    val title: String,
    val priceWithoutDiscount: Int,
    val discountPrice: Int,
    val picture: String
) {
    fun toCardBestDataModel() =
        CardBestDataModel(id, isFavorite, title, priceWithoutDiscount, discountPrice, picture)

    companion object {
        fun toCardBestEntity(cardBestDataModel: CardBestDataModel) =
            CardBestEntity(
                cardBestDataModel.id,
                cardBestDataModel.isFavorite,
                cardBestDataModel.title,
                cardBestDataModel.priceWithoutDiscount,
                cardBestDataModel.discountPrice,
                cardBestDataModel.picture
            )
    }
}

fun List<CardBestEntity>.toCardBestDataModel():List<CardBestDataModel> = map (CardBestEntity::toCardBestDataModel )
fun List<CardBestDataModel>.toCardBestEntity():List<CardBestEntity> = map(CardBestEntity::toCardBestEntity )

