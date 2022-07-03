package com.example.test.data.dataModel.homeScreen
data class HotSalesDomainModel(
    val id: Long,
    val isNew: Boolean,
    val title: String,
    val subtitle: String,
    val picture: String,
    val isBuy: Boolean
) {
}