package com.example.test.app.data.repositoryImpl

import com.example.test.data.ApiService.Api
import com.example.test.data.dataModel.myCartScreen.MyCartDataModel
import com.example.test.domain.repository.RepositoryMyCartScreen
import retrofit2.Response
import javax.inject.Inject

class RepositoryMyCartScreenImpl @Inject constructor(
    private val apiService: Api
    ): RepositoryMyCartScreen {
    override suspend fun getMyCart(): Response<MyCartDataModel> {
        return apiService.getMyCartPhone()
    }
}