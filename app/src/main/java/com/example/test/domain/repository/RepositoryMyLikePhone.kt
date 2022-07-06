package com.example.test.domain.repository

import com.example.test.data.dataModel.homeScreen.CardBestDataModel
import kotlinx.coroutines.flow.Flow

interface RepositoryMyLikePhone {
    val dataMyLike: Flow<List<CardBestDataModel>>
}