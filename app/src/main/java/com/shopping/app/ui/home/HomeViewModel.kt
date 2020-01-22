package com.shopping.app.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.shopping.app.api.model.Resource
import com.shopping.app.api.model.ResourceError
import com.shopping.app.api.repo.HomeRepo
import com.shopping.app.vo.home.HomeResponse

class HomeViewModel(private val repo: HomeRepo) : ViewModel() {

    fun data(): LiveData<Resource<List<HomeResponse>, ResourceError>> =
        repo.getHomeList()
}
