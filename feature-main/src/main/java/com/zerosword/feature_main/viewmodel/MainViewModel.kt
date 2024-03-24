package com.zerosword.feature_main.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zerosword.data.repositoryimpl.MainRepositoryImpl
import com.zerosword.domain.reporitory.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val mainRepository: MainRepository
): ViewModel() {
    private val mainMessage: MutableState<String> = mutableStateOf("Hello")

    suspend fun updateMainData() = viewModelScope.launch {
        mainRepository.getData(
            onSuccess = {
                mainMessage.value = it
            },
            onError = {
                mainMessage.value = it
            }
        )
    }
}