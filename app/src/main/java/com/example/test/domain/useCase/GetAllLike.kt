package com.example.test.domain.useCase


import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import com.example.test.domain.domainModel.homeScreen.CardBestDomainModel
import com.example.test.domain.repository.RepositoryHomeScreen
import com.example.test.domain.repository.RepositoryMyLikePhone
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetAllLike @Inject constructor(
    private val repository: RepositoryMyLikePhone
    ) {

    fun get(): LiveData<List<CardBestDomainModel>> {
        return repository.dataMyLike
            .map{ it -> it.map { it.toCardBestDomainModel() }}
            .asLiveData(Dispatchers.Default)
    }}