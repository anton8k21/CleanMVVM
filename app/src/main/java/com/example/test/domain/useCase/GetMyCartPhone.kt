package com.example.test.domain.useCase

import com.example.test.data.dataModel.myCartScreen.MyCartDataModel
import com.example.test.data.dataModel.myCartScreen.MyCartDomainModel
import com.example.test.domain.repository.RepositoryMyCartScreen

class GetMyCartPhone(
    private val repository: RepositoryMyCartScreen
    ) {

    suspend fun getMyCart(): MyCartDomainModel {
        val response = repository.getMyCart()
        return response.body()?.toMyCartDomainModel() ?: throw Exception()
    }
}