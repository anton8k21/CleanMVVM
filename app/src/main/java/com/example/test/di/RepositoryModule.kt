package com.example.test.di

import com.example.test.app.data.repositoryImpl.RepositoryDetailsScreenImpl
import com.example.test.app.data.repositoryImpl.RepositoryHomeScreenImpl
import com.example.test.app.data.repositoryImpl.RepositoryMyCartScreenImpl
import com.example.test.data.repositoryImpl.RepositoryMyLikePhoneImpl
import com.example.test.domain.repository.RepositoryDetailsScreen
import com.example.test.domain.repository.RepositoryHomeScreen
import com.example.test.domain.repository.RepositoryMyCartScreen
import com.example.test.domain.repository.RepositoryMyLikePhone
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class RepositoryModule {

    @Binds
    abstract fun provideRepositoryHomeScreen(repository: RepositoryHomeScreenImpl): RepositoryHomeScreen

    @Binds
    abstract fun provideRepositoryDetailsScreen(repository: RepositoryDetailsScreenImpl): RepositoryDetailsScreen

    @Binds
    abstract fun provideRepositoryMyCartScreen(repository: RepositoryMyCartScreenImpl): RepositoryMyCartScreen

    @Binds
    abstract fun provideRepositoryMyLikePhone(repository: RepositoryMyLikePhoneImpl): RepositoryMyLikePhone


}