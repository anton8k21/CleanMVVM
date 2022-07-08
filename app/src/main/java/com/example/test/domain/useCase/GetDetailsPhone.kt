package com.example.test.domain.useCase

import com.example.test.data.dataModel.detailsScreen.DetailsPhoneDomainModel
import com.example.test.domain.repository.RepositoryDetailsScreen
import javax.inject.Inject

class GetDetailsPhone @Inject constructor(
    private val repositoryDetails: RepositoryDetailsScreen
) {

    suspend fun get(): DetailsPhoneDomainModel {
        val response = repositoryDetails.getDetailPhone()
        return response.body()?.toDetailsPhoneDomainModel() ?: throw Exception()
    }
}