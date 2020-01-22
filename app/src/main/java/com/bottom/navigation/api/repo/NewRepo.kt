package com.bottom.navigation.api.repo

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.bottom.navigation.api.ApiService
import com.bottom.navigation.api.model.BaseResponse
import com.bottom.navigation.api.model.Resource
import com.bottom.navigation.api.model.ResourceError
import com.bottom.navigation.vo.NewsResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewRepo(private val apiService: ApiService) {

    fun getNewsList(): LiveData<Resource<List<NewsResponse>, ResourceError>> {
        val data = MutableLiveData<Resource<List<NewsResponse>, ResourceError>>()
        data.postValue(Resource.loading(null, null))

        apiService.getNewsList().enqueue(object : Callback<BaseResponse<List<NewsResponse>>> {

            override fun onResponse(call: Call<BaseResponse<List<NewsResponse>>>,
                                    response: Response<BaseResponse<List<NewsResponse>>>) {
                when (response.isSuccessful) {
                    true -> {
                        val body = response.body()
                        data.postValue(Resource.success(null, body?.responseObject))
                    } else -> {
                        when (response.code()) {
                            401 -> {
                                val error = ResourceError(
                                    code = "401",
                                    message = response.errorBody()?.string()!!
                                )
                                data.postValue(Resource.unauthorized(error, null))
                            } else -> {
                                val error = ResourceError(
                                    code = response.code().toString(),
                                    message = response.errorBody()?.string()!!
                                )
                                data.postValue(Resource.error(error, null))
                            }
                        }
                    }
                }
            }

            @SuppressLint("DefaultLocale")
            override fun onFailure(call: Call<BaseResponse<List<NewsResponse>>>, t: Throwable) {
                if (t.message?.toLowerCase()?.trim() == "timeout"){
                    val error = ResourceError(
                        code = "408",
                        message = t.message.toString()
                    )
                    data.postValue(Resource.error(error, null))
                }
                else {
                    val error = ResourceError(
                        code = "-1000",
                        message = t.message.toString()
                    )
                    data.postValue(Resource.error(error, null))
                }
            }
        })

        return data
    }
}