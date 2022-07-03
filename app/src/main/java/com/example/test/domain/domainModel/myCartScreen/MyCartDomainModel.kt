package com.example.test.data.dataModel.myCartScreen

data class MyCartDomainModel(
    val basket: List<BasketDomainModel>,
    val delivery: String,
    val id: Long,
    val total: Int
) {
}