package com.example.test.app.data.repositoryImpl

import android.util.Log
import com.example.test.data.ApiService.ApiService
import com.example.test.data.dataModel.homeScreen.CardBestDataModel
import com.example.test.data.dataModel.homeScreen.HomePhoneDataModel
import com.example.test.data.dp.Dao
import com.example.test.data.dp.entity.toCardBestDataModel
import com.example.test.data.dp.entity.toCardBestEntity
import com.example.test.domain.repository.RepositoryHomeScreen
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import retrofit2.Response
import kotlin.math.log


class RepositoryHomeScreenImpl(
    private val apiService: ApiService,
private val dao: Dao):
    RepositoryHomeScreen {
    override val data =
        dao.getAll()
            .map {it.toCardBestDataModel() }
            .flowOn(Dispatchers.Default)


    override suspend fun likes(id: Long) {
        dao.like(id)
    }

    override suspend fun disLike(id: Long) {
        dao.disLike(id)
    }

    override suspend fun getAll(): Response<HomePhoneDataModel> {
        val response = apiService.api.getHomePhone()
        val body = response.body()
        Log.d("mmm", "$body")
        dao.insert(body?.bestSeller!!.toCardBestEntity())
        return response
    }


}