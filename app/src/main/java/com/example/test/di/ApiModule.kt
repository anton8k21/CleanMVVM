package com.example.test.di

import com.example.test.data.ApiService.Api
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

private const val BASE_URL = "https://run.mocky.io/v3/"
@Module
@InstallIn(SingletonComponent::class)
class ApiModule {

    @Provides
@Singleton
    fun provideOkHttp(): OkHttpClient =
        OkHttpClient.Builder()
            .build()
    @Provides
@Singleton
    fun provideRetrofit(client: OkHttpClient): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .client(client)
        .build()

    @Provides
    fun provideApiService(retrofit: Retrofit): Api = retrofit.create()

}

