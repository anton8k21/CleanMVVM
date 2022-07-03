package com.example.test.app.data.repositoryImpl

import com.example.test.data.ApiService.ApiService
import com.example.test.data.dataModel.homeScreen.CardBestDataModel
import com.example.test.data.dataModel.homeScreen.HomePhoneDataModel
import com.example.test.domain.repository.RepositoryHomeScreen
import retrofit2.Response


class RepositoryHomeScreenImpl(private val apiService: ApiService):
    RepositoryHomeScreen {

    override fun likes(id: Long) {
        TODO("Not yet implemented")
    }

    override suspend fun getAll(): Response<HomePhoneDataModel> {
        return apiService.api.getHomePhone()
    }

    override fun getListLike(): List<CardBestDataModel> {
        TODO("Not yet implemented")
    }

}