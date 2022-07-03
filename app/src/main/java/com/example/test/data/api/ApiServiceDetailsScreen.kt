package com.example.test.detailsScreen.data

import androidx.viewbinding.BuildConfig
import com.example.test.data.dataModel.detailsScreen.DetailsPhoneDataModel
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


interface CardApi{
    @GET("6c14c560-15c6-4248-b9d2-b4508df7d4f5")
    suspend fun getCard(): Response<DetailsPhoneDataModel>
}


object CardApiService{
    val api: CardApi by lazy{
        retrofit.create(CardApi::class.java)
    }
}