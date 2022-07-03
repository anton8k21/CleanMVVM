package com.example.test.app.data.repositoryImpl

import com.example.test.myCartScreen.ApiServiceMyCard
import com.example.test.data.dataModel.myCartScreen.MyCartDataModel
import com.example.test.domain.repository.RepositoryMyCartScreen
import retrofit2.Response

class RepositoryMyCartScreenImpl(
    private val apiService: ApiServiceMyCard): RepositoryMyCartScreen {
    override suspend fun getMyCart(): Response<MyCartDataModel> {
        return apiService.api.getCard()
    }
}