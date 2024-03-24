package com.zerosword.data.services

import com.skydoves.sandwich.ApiResponse
import com.zerosword.data.response.MainResponse
import retrofit2.http.GET

interface MainService {

    /*
    * API 작성
    * 반드시 suspend function 으로 만들어야 ApiResponse를 사용할 수 있습니다.
    * */

    @GET("get")
    suspend fun getData(): ApiResponse<MainResponse>

}