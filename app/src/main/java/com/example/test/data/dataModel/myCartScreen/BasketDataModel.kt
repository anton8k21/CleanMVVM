package com.example.test.data.dataModel.myCartScreen
data class BasketDataModel(
    val id: Long,
    val images: String,
    val price: Int,
    val title: String
){
    fun toBasketDomainModel(): BasketDomainModel{
        val value = BasketDomainModel(
            id = id,
            images = images,
            price = price,
            title = title)
        return value
    }

}