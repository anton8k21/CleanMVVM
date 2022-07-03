package com.example.test.data.ApiService

import androidx.viewbinding.BuildConfig
import com.example.test.data.dataModel.detailsScreen.DetailsPhoneDataModel
import com.example.test.data.dataModel.homeScreen.HomePhoneDataModel
import com.example.test.data.dataModel.myCartScreen.MyCartDataModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://run.mocky.io/v3/"

private val logging = HttpLoggingInterceptor().apply {
    if (BuildConfig.DEBUG) {
        level = HttpLoggingInterceptor.Level.BODY
    }
}

private val client = OkHttpClient.Builder()
    .addInterceptor(logging)
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .client(client)
    .build()


interface Api{
    @GET("654bd15e-b121-49ba-a588-960956b15175")
    suspend fun getHomePhone(): Response<HomePhoneDataModel>

    @GET("53539a72-3c5f-4f30-bbb1-6ca10d42c149")
    suspend fun getMyCartPhone(): Response<MyCartDataModel>

    @GET("6c14c560-15c6-4248-b9d2-b4508df7d4f5")
    suspend fun getDetailsPhone(): Response<DetailsPhoneDataModel>
}


object ApiService{
    val api: Api by lazy{
        retrofit.create(Api::class.java)
    }
}