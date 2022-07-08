package com.example.test.di

import android.content.Context

import androidx.room.Room
import com.example.test.data.dp.AppDb
import com.example.test.data.dp.Dao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DbModule {


    @Singleton
    @Provides
    fun provideAppDb(
        @ApplicationContext context:Context
    ): AppDb
    = Room.databaseBuilder(context, AppDb::class.java, "app.db")
        .fallbackToDestructiveMigration()
        .build()

    @Provides
    fun provideDao(appDb: AppDb): Dao = appDb.dao()


}