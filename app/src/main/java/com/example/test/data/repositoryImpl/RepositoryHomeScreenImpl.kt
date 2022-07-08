package com.example.test.app.data.repositoryImpl

import com.example.test.data.ApiService.Api
import com.example.test.data.dataModel.homeScreen.HomePhoneDataModel
import com.example.test.data.dp.Dao
import com.example.test.data.dp.entity.toCardBestDataModel
import com.example.test.data.dp.entity.toCardBestEntity
import com.example.test.domain.repository.RepositoryHomeScreen
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import retrofit2.Response
import javax.inject.Inject


class RepositoryHomeScreenImpl @Inject constructor(
    private val apiService: Api,
    private val dao: Dao
    ): RepositoryHomeScreen {
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
        val response = apiService.getHomePhone()
        val body = response.body()
        dao.insert(body?.bestSeller!!.toCardBestEntity())
        return response
    }


}