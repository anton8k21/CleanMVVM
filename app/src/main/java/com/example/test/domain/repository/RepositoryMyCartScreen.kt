package com.example.test.domain.repository

import com.example.test.data.dataModel.myCartScreen.MyCartDataModel
import retrofit2.Response

interface RepositoryMyCartScreen {
    suspend fun getMyCart(): Response<MyCartDataModel>
}