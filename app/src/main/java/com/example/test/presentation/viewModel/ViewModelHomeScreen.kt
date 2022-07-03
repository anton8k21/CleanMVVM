package com.example.test.presentation.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.test.data.ApiService.ApiService
import com.example.test.app.data.repositoryImpl.RepositoryHomeScreenImpl
import com.example.test.data.dataModel.homeScreen.HomePhoneDomainModel
import com.example.test.domain.useCase.GetAllPhone
import kotlinx.coroutines.launch

class ViewModelHomeScreen : ViewModel() {
    private var _data: MutableLiveData<HomePhoneDomainModel> = MutableLiveData()
    val data: MutableLiveData<HomePhoneDomainModel> = _data

    private val repository by lazy {
        RepositoryHomeScreenImpl(ApiService)
    }
    private val useCaseGetPhone by lazy {
        GetAllPhone(repository = repository)
    }

    init {
        loadPosts()
    }

    private fun loadPosts() = viewModelScope.launch {
        val dataHomeScreen = useCaseGetPhone.getAllPhone()
        data.postValue(dataHomeScreen)
    }
}