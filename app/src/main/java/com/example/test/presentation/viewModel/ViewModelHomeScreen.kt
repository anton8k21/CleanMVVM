package com.example.test.presentation.viewModel

import android.app.Application
import androidx.lifecycle.*
import com.example.test.data.ApiService.ApiService
import com.example.test.app.data.repositoryImpl.RepositoryHomeScreenImpl
import com.example.test.data.dataModel.homeScreen.HomePhoneDomainModel
import com.example.test.data.dp.AppDb
import com.example.test.domain.domainModel.homeScreen.CardBestDomainModel
import com.example.test.domain.useCase.GetAllBestPhone
import com.example.test.domain.useCase.GetAllLike
import com.example.test.domain.useCase.GetAllPhone
import com.example.test.domain.useCase.LikeById
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ViewModelHomeScreen(application: Application) : AndroidViewModel(application) {
    private var _data: MutableLiveData<HomePhoneDomainModel> = MutableLiveData()
    val data: MutableLiveData<HomePhoneDomainModel> = _data

    private val repository by lazy {
        RepositoryHomeScreenImpl(ApiService, AppDb.getInstance(context = application).dao())
    }
    private val useCaseGetPhone by lazy {
        GetAllPhone(repository = repository)
    }

    private val useCaseGetBestPhone by lazy {
        GetAllBestPhone(repository = repository)
    }

    private val useCaseLikes by lazy {
        LikeById(repository = repository)
    }

     fun like(id:Long) = viewModelScope.launch {
         useCaseLikes.likeById(id)
     }

     fun disLike(id: Long) = viewModelScope.launch {
         useCaseLikes.disLike(id)
     }

    val dataBest:LiveData<List<CardBestDomainModel>> = useCaseGetBestPhone.get()

    init {
        loadPosts()
    }

    private fun loadPosts() = viewModelScope.launch {
        val dataHomeScreen = useCaseGetPhone.getAllPhone()
        data.postValue(dataHomeScreen)
    }
}