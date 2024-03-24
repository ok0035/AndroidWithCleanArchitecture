package com.zerosword.data.response

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class MainResponse(
    @SerializedName("origin")
    val origin: String? = null
)
