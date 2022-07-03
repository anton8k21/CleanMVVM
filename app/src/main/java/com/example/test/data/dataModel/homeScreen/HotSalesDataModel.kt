package com.example.test.data.dataModel.homeScreen
data class HotSalesDataModel(
    val id: Long,
    val isNew: Boolean,
    val title: String,
    val subtitle: String,
    val picture: String,
    val isBuy: Boolean
) {

    fun toHotSalesDomainModel(): HotSalesDomainModel{
        val value = HotSalesDomainModel(
            id = id,
            isNew = isNew,
            title = title,
            subtitle = subtitle,
            picture = picture,
            isBuy = isBuy
        )
        return value
    }
}