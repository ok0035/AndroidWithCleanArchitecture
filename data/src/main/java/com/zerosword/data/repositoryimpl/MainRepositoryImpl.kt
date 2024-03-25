package com.zerosword.data.repositoryimpl

import com.skydoves.sandwich.message
import com.skydoves.sandwich.suspendOnFailure
import com.skydoves.sandwich.suspendOnSuccess
import com.zerosword.data.services.MainService
import com.zerosword.domain.reporitory.MainRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MainRepositoryImpl @Inject constructor(
    private val mainService: MainService
) : MainRepository {

    override suspend fun getData(
        onSuccess: (res: String) -> Unit,
        onError: (errorMessage: String) -> Unit
    ) {
        mainService.getData()
            .suspendOnSuccess {
                onSuccess("Nice to meet you ${(this.data.origin ?: "")}")
            }.suspendOnFailure {
                onError(this.message())
            }
    }

}