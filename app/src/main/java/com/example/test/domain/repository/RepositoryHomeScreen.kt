package com.example.test.domain.repository

import com.example.test.data.dataModel.homeScreen.CardBestDataModel
import com.example.test.data.dataModel.homeScreen.HomePhoneDataModel
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface RepositoryHomeScreen {

    val data: Flow<List<CardBestDataModel>>
    suspend fun likes(id: Long)
    suspend fun disLike(id: Long)
   suspend fun getAll(): Response<HomePhoneDataModel>
}