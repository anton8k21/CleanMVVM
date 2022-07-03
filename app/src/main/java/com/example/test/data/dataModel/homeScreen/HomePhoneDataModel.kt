package com.example.test.data.dataModel.homeScreen

import com.google.gson.annotations.SerializedName

data class HomePhoneDataModel(
    @SerializedName("home_store")
    val homeStore: List<HotSalesDataModel>,
    @SerializedName("best_seller")
    val bestSeller: List<CardBestDataModel>
) {

    fun toHomePhoneDomainModel(): HomePhoneDomainModel{
        val value = HomePhoneDomainModel(
            homeStore = homeStore.map { hotSalesDataModel ->
                hotSalesDataModel.toHotSalesDomainModel()
            },
            bestSeller = bestSeller.map { cardBestDataModel ->
                cardBestDataModel.toCardBestDomainModel()
            })
        return value
    }
}