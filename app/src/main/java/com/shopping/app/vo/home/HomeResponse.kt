package com.shopping.app.vo.home

import com.google.gson.annotations.SerializedName

data class HomeResponse(
    @SerializedName("banner")
    val banner: ArrayList<BannerData> = ArrayList(),
    @SerializedName("category")
    val category: ArrayList<CategoryData> = ArrayList(),
    @SerializedName("items")
    val items: ArrayList<ItemsResponse> = ArrayList()
)