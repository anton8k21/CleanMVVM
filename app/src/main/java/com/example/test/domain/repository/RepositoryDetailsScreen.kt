package com.example.test.domain.repository

import com.example.test.data.dataModel.detailsScreen.DetailsPhoneDataModel
import retrofit2.Response

interface RepositoryDetailsScreen {
   suspend fun getDetailPhone(): Response<DetailsPhoneDataModel>
}