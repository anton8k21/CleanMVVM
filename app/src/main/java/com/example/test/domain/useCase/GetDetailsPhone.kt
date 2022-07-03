package com.example.test.domain.useCase

import com.example.test.data.dataModel.detailsScreen.DetailsPhoneDataModel
import com.example.test.data.dataModel.detailsScreen.DetailsPhoneDomainModel
import com.example.test.domain.repository.RepositoryDetailsScreen

class GetDetailsPhone(
    private val repositoryDetails: RepositoryDetailsScreen
) {

    suspend fun get(): DetailsPhoneDomainModel {
        val response = repositoryDetails.getDetailPhone()
        return response.body()?.toDetailsPhoneDomainModel() ?: throw Exception()
    }
}