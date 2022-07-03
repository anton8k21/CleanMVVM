package com.example.test.presentation.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.test.myCartScreen.ApiServiceMyCard
import com.example.test.data.dataModel.myCartScreen.MyCartDataModel
import com.example.test.app.data.repositoryImpl.RepositoryMyCartScreenImpl
import com.example.test.data.dataModel.myCartScreen.MyCartDomainModel
import com.example.test.domain.useCase.GetMyCartPhone
import kotlinx.coroutines.launch

class ViewModelMyCartScreen: ViewModel() {
    var data: MutableLiveData<MyCartDomainModel> = MutableLiveData()

    private val repositoryMyCart by lazy {
        RepositoryMyCartScreenImpl(ApiServiceMyCard)
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
