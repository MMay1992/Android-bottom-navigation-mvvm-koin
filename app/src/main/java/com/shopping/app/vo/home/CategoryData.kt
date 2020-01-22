package com.shopping.app.vo.home

import com.google.gson.annotations.SerializedName

data class CategoryData(
    @SerializedName("id")
    val id: String = "",
    @SerializedName("title")
    val title: String = "",
    @SerializedName("imageUrl")
    val imageUrl: String = ""
)