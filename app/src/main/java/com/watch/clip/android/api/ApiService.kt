package com.watch.clip.android.api

import com.watch.clip.android.api.model.BaseResponse
import com.watch.clip.android.vo.NewsResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("5e2722ff2f00004a00a4fa09")
    fun getNewsList(): Call<BaseResponse<List<NewsResponse>>>

}