package com.example.test.domain.useCase

import com.example.test.domain.repository.RepositoryHomeScreen

class LikeById(private val repository: RepositoryHomeScreen) {

    suspend fun likeById(id: Long){
        repository.likes(id = id)
    }

    suspend fun disLike(id:Long){
        repository.disLike(id = id)
    }
}