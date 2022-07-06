package com.example.test.presentation.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.test.app.data.repositoryImpl.RepositoryHomeScreenImpl
import com.example.test.data.ApiService.ApiService
import com.example.test.data.dp.AppDb
import com.example.test.data.repositoryImpl.RepositoryMyLikePhoneImpl
import com.example.test.domain.domainModel.homeScreen.CardBestDomainModel
import com.example.test.domain.repository.RepositoryMyLikePhone
import com.example.test.domain.useCase.GetAllLike
import com.example.test.domain.useCase.GetAllPhone
import com.example.test.domain.useCase.LikeById
import kotlinx.coroutines.launch

class ViewModelMyLikePhone(application: Application): AndroidViewModel(application) {

    private val repository by lazy {
        RepositoryMyLikePhoneImpl(AppDb.getInstance(context = application).dao())
    }
    private val repositoryHome by lazy {
        RepositoryHomeScreenImpl(ApiService, AppDb.getInstance(context = application).dao())
    }

    private val useCaseGetPhone by lazy {
        GetAllLike(repository = repository)
    }

    private val useCaseLikes by lazy {
        LikeById(repository = repositoryHome)
    }

    fun like(id:Long) = viewModelScope.launch {
        useCaseLikes.likeById(id)
    }

    fun disLike(id: Long) = viewModelScope.launch {
        useCaseLikes.disLike(id)
    }

    val data: LiveData<List<CardBestDomainModel>> = useCaseGetPhone.get()


}