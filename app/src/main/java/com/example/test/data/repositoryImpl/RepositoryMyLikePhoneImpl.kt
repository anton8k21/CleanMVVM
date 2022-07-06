package com.example.test.data.repositoryImpl

import com.example.test.data.dataModel.homeScreen.CardBestDataModel
import com.example.test.data.dp.Dao
import com.example.test.data.dp.entity.toCardBestDataModel
import com.example.test.domain.repository.RepositoryMyLikePhone
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map

class RepositoryMyLikePhoneImpl(private val dao: Dao) :RepositoryMyLikePhone {

    override val dataMyLike =
        dao.getAllLike()
        .map {it.toCardBestDataModel() }
        .flowOn(Dispatchers.Default)
}