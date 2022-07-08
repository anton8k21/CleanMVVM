package com.example.test.presentation.viewModel

import android.app.Application
import androidx.lifecycle.*
import com.example.test.data.dataModel.homeScreen.HomePhoneDomainModel
import com.example.test.domain.domainModel.homeScreen.CardBestDomainModel
import com.example.test.domain.repository.RepositoryHomeScreen
import com.example.test.domain.useCase.GetAllBestPhone
import com.example.test.domain.useCase.GetAllPhone
import com.example.test.domain.useCase.LikeById
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Singleton

@HiltViewModel
class ViewModelHomeScreen @Inject constructor(
    private val useCaseGetBestPhone: GetAllBestPhone,
    private val useCaseGetPhone: GetAllPhone,
    private val useCaseLikes: LikeById
) : ViewModel() {
    private var _data: MutableLiveData<HomePhoneDomainModel> = MutableLiveData()
    val data: MutableLiveData<HomePhoneDomainModel> = _data

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