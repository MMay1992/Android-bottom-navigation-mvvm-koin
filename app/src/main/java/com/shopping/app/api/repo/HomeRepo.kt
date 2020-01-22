package com.shopping.app.api.repo

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.shopping.app.api.ApiService
import com.shopping.app.api.model.BaseResponse
import com.shopping.app.api.model.Resource
import com.shopping.app.api.model.ResourceError
import com.shopping.app.vo.home.HomeResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeRepo(private val apiService: ApiService) {

    fun getHomeList(): LiveData<Resource<List<HomeResponse>, ResourceError>> {
        val data = MutableLiveData<Resource<List<HomeResponse>, ResourceError>>()
        data.postValue(Resource.loading(null, null))

        apiService.getHomeList().enqueue(object : Callback<BaseResponse<List<HomeResponse>>> {

            override fun onResponse(call: Call<BaseResponse<List<HomeResponse>>>,
                                    response: Response<BaseResponse<List<HomeResponse>>>) {
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
            override fun onFailure(call: Call<BaseResponse<List<HomeResponse>>>, t: Throwable) {
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