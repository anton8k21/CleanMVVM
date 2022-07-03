package com.example.test.myCartScreen

import androidx.viewbinding.BuildConfig
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


interface CartApi{
    @GET("53539a72-3c5f-4f30-bbb1-6ca10d42c149")
    suspend fun getCard(): Response<MyCartDataModel>
}


object ApiServiceMyCard{
    val api: CartApi by lazy{
        retrofit.create(CartApi::class.java)
    }
}