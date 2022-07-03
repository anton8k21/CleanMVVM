package com.example.test.domain.repository

import com.example.test.data.dataModel.homeScreen.CardBestDataModel
import com.example.test.data.dataModel.homeScreen.HomePhoneDataModel
import retrofit2.Response

interface RepositoryHomeScreen {

    fun likes(id: Long)
   suspend fun getAll(): Response<HomePhoneDataModel>
    fun getListLike(): List<CardBestDataModel>
}