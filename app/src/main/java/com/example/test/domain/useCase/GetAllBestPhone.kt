package com.example.test.domain.useCase

import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import com.example.test.domain.domainModel.homeScreen.CardBestDomainModel
import com.example.test.domain.repository.RepositoryHomeScreen
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetAllBestPhone @Inject constructor(
    private val repository: RepositoryHomeScreen
    ) {
    fun get():LiveData<List<CardBestDomainModel>>{
        return repository.data
            .map{ it -> it.map { it.toCardBestDomainModel() }}
            .asLiveData(Dispatchers.Default)
    }
}