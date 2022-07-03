package com.example.test.app.data.repositoryImpl

import com.example.test.detailsScreen.data.CardApiService
import com.example.test.data.dataModel.detailsScreen.DetailsPhoneDataModel
import com.example.test.domain.repository.RepositoryDetailsScreen
import retrofit2.Response

class RepositoryDetailsScreenImpl(
    private val apiService: CardApiService
    ): RepositoryDetailsScreen {
    override suspend fun getDetailPhone(): Response<DetailsPhoneDataModel> {
        return apiService.api.getCard()
    }
}