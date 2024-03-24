package com.zerosword.data.repositoryimpl

import com.skydoves.sandwich.suspendOnFailure
import com.skydoves.sandwich.suspendOnSuccess
import com.zerosword.data.services.MainService
import com.zerosword.domain.reporitory.MainRepository
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(
    private val mainService: MainService
) : MainRepository {

    override suspend fun getData(
        onSuccess: () -> Unit,
        onError: () -> Unit
    ) {
        mainService.getData()
            .suspendOnSuccess {
                onSuccess()
            }.suspendOnFailure {
                onError()
            }
    }
}