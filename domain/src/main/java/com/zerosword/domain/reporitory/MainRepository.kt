package com.zerosword.domain.reporitory

interface MainRepository {
    suspend fun getData(
        onSuccess: (res: String) -> Unit,
        onError: (errorMessage: String) -> Unit
    )
}