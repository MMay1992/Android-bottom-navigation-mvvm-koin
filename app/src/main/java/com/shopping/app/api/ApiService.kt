package com.shopping.app.api

import com.shopping.app.api.model.BaseResponse
import com.shopping.app.vo.NewsResponse
import com.shopping.app.vo.home.HomeResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("5e2722ff2f00004a00a4fa09")
    fun getNewsList(): Call<BaseResponse<List<NewsResponse>>>

    @GET("5e2815733200001206d83eb3")
    fun getHomeList(): Call<BaseResponse<List<HomeResponse>>>

}