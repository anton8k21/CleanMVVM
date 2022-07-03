package com.example.test.domain.useCase

import com.example.test.data.dataModel.homeScreen.HomePhoneDomainModel
import com.example.test.domain.repository.RepositoryHomeScreen

class GetAllPhone(private val repository: RepositoryHomeScreen) {

    suspend fun getAllPhone(): HomePhoneDomainModel {
        val response = repository.getAll()
        return response.body()?.toHomePhoneDomainModel() ?: throw Exception()
    }
}