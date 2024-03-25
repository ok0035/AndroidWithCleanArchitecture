package com.zerosword.feature_main.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.zerosword.data.repositoryimpl.FakeMainRepositoryImpl
import com.zerosword.domain.reporitory.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val mainRepository: MainRepository
) : ViewModel() {
    private val _mainMessage: MutableStateFlow<String> = MutableStateFlow("API CALLING...")
    val mainMessage: StateFlow<String> get() = _mainMessage

    init {
        viewModelScope.launch {
            updateMainData()
        }
    }

    private suspend fun updateMainData() = viewModelScope.launch {
        mainRepository.getData(
            onSuccess = {
                _mainMessage.value = it
            },
            onError = {
                _mainMessage.value = it
            }
        )
    }
}