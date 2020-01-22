package com.shopping.app.vo.home

import com.google.gson.annotations.SerializedName

data class ItemsResponse(
    @SerializedName("id")
    val id: String = "",
    @SerializedName("title")
    val title: String = "",
    @SerializedName("description")
    val description: String = "",
    @SerializedName("imageUrl")
    val imageUrl: String = ""
)