package com.shopping.app.vo.home

import com.google.gson.annotations.SerializedName

data class BannerData(
    @SerializedName("id")
    val id: String = "",
    @SerializedName("imageUrl")
    val imageUrl: String = ""
)