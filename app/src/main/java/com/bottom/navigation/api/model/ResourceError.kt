package com.bottom.navigation.api.model

import com.google.gson.annotations.SerializedName

data class ResourceError(
    @SerializedName("status") var code: String,
    @SerializedName("message") var message: String)