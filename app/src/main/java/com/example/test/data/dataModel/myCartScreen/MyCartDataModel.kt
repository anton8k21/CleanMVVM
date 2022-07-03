package com.example.test.data.dataModel.myCartScreen

data class MyCartDataModel(
    val basket: List<BasketDataModel>,
    val delivery: String,
    val id: Long,
    val total: Int
) {

    fun toMyCartDomainModel(): MyCartDomainModel {
        val value = MyCartDomainModel(
            basket = basket.map { basketDataModel ->
            basketDataModel.toBasketDomainModel()
            },
            delivery = delivery,
            id = id,
            total = total)
        return value
    }
}