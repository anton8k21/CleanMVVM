package com.example.test.detailsScreen.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.test.data.dataModel.detailsScreen.DetailsPhoneDomainModel
import com.example.test.domain.repository.RepositoryDetailsScreen
import com.example.test.domain.useCase.GetDetailsPhone
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ViewModelDetailsScreen @Inject constructor(
    private val useCaseDetailsPhone: GetDetailsPhone
    ) : ViewModel() {
    private var _data: MutableLiveData<DetailsPhoneDomainModel> = MutableLiveData()
    val data: MutableLiveData<DetailsPhoneDomainModel> = _data

    init {
        loadPosts()
    }

    private fun loadPosts() = viewModelScope.launch {
        val infoCard = useCaseDetailsPhone.get()
        data.postValue(infoCard)

    }
}
