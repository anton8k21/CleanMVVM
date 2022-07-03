package com.example.test.data.dataModel.homeScreen

import com.example.test.domain.domainModel.homeScreen.CardBestDomainModel
import com.google.gson.annotations.SerializedName

data class HomePhoneDomainModel(
    @SerializedName("home_store")
    val homeStore: List<HotSalesDomainModel>,
    @SerializedName("best_seller")
    val bestSeller: List<CardBestDomainModel>
) {
}