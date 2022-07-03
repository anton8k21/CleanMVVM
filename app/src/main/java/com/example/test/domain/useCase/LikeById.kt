package com.example.test.domain.useCase

import com.example.test.domain.repository.RepositoryHomeScreen

class LikeById(private val repository: RepositoryHomeScreen) {

    fun likeById(id: Long){
        repository.likes(id = id)
    }
}