package com.example.test.presentation.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.test.data.dataModel.myCartScreen.MyCartDomainModel
import com.example.test.domain.repository.RepositoryMyCartScreen
import com.example.test.domain.useCase.GetMyCartPhone
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ViewModelMyCartScreen @Inject constructor(
    private val getMyCartUseCase: GetMyCartPhone
): ViewModel() {
    private var _data: MutableLiveData<MyCartDomainModel> = MutableLiveData()
    val data: MutableLiveData<MyCartDomainModel> = _data

    init {
        loadPosts()
    }

    
    private fun loadPosts() = viewModelScope.launch {
        val myCart = getMyCartUseCase.getMyCart()
        data.postValue(myCart)

    }
}
