package com.zerosword.domain.reporitory

interface MainRepository {
    suspend fun getData(
        onSuccess: () -> Unit,
        onError: () -> Unit
    )
}