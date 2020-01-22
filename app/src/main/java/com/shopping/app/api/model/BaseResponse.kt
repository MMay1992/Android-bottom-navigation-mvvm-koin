package com.shopping.app.api.model

import com.google.gson.annotations.SerializedName

data class BaseResponse<T>(
    @SerializedName("status") var code: String,
    @SerializedName("message") var message: String,
    @SerializedName("responseObject") var responseObject: T)