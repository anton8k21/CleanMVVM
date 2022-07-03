package com.example.test.detailsScreen.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.test.detailsScreen.data.CardApiService
import com.example.test.data.dataModel.detailsScreen.DetailsPhoneDataModel
import com.example.test.app.data.repositoryImpl.RepositoryDetailsScreenImpl
import com.example.test.data.dataModel.detailsScreen.DetailsPhoneDomainModel
import com.example.test.domain.useCase.GetDetailsPhone
import kotlinx.coroutines.launch

class ViewModelDetailsScreen: ViewModel() {
        var data: MutableLiveData<DetailsPhoneDomainModel> = MutableLiveData()
    private val repositoryDetails by lazy {
        RepositoryDetailsScreenImpl(CardApiService)
    }
    private val useCaseDetailsPhone by lazy {
        GetDetailsPhone(repositoryDetails)
    }

        init {
            loadPosts()
        }

        private fun loadPosts() = viewModelScope.launch {
            val infoCard = useCaseDetailsPhone.get()
            data.postValue(infoCard)

        }
    }
