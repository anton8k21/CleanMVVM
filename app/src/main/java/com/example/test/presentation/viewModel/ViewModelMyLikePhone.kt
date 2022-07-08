package com.example.test.presentation.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.test.domain.domainModel.homeScreen.CardBestDomainModel
import com.example.test.domain.repository.RepositoryHomeScreen
import com.example.test.domain.repository.RepositoryMyLikePhone
import com.example.test.domain.useCase.GetAllLike
import com.example.test.domain.useCase.LikeById
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ViewModelMyLikePhone @Inject constructor(
    private val useCaseGetPhone: GetAllLike,
    private val useCaseLikes: LikeById
): ViewModel() {


    fun like(id:Long) = viewModelScope.launch {
        useCaseLikes.likeById(id)
    }

    fun disLike(id: Long) = viewModelScope.launch {
        useCaseLikes.disLike(id)
    }

    val data: LiveData<List<CardBestDomainModel>> = useCaseGetPhone.get()


}