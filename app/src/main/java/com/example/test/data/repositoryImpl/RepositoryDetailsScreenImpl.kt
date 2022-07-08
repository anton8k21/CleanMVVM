package com.example.test.app.data.repositoryImpl

import com.example.test.data.ApiService.Api
import com.example.test.data.dataModel.detailsScreen.DetailsPhoneDataModel
import com.example.test.domain.repository.RepositoryDetailsScreen
import retrofit2.Response
import javax.inject.Inject


class RepositoryDetailsScreenImpl @Inject constructor(
    private val apiService: Api
    ): RepositoryDetailsScreen {
    override suspend fun getDetailPhone(): Response<DetailsPhoneDataModel> {
        return apiService.getDetailsPhone()
    }
}