package com.example.test.presentation.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.test.app.data.repositoryImpl.RepositoryMyCartScreenImpl
import com.example.test.data.ApiService.ApiService
import com.example.test.data.dataModel.myCartScreen.MyCartDomainModel
import com.example.test.domain.useCase.GetMyCartPhone
import kotlinx.coroutines.launch

class ViewModelMyCartScreen: ViewModel() {
    private var _data: MutableLiveData<MyCartDomainModel> = MutableLiveData()
    val data: MutableLiveData<MyCartDomainModel> = _data

    private val repositoryMyCart by lazy {
        RepositoryMyCartScreenImpl(ApiService)
    }

    private val getMyCartUseCase by lazy {
        GetMyCartPhone(repositoryMyCart)
    }

    init {
        loadPosts()
    }

    
    private fun loadPosts() = viewModelScope.launch {
        val myCart = getMyCartUseCase.getMyCart()
        data.postValue(myCart)

    }
}
