package com.shopping.app.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.shopping.app.api.model.Resource
import com.shopping.app.api.model.ResourceError
import com.shopping.app.api.repo.NewRepo
import com.shopping.app.vo.NewsResponse

class MainViewModel(private val repo: NewRepo): ViewModel() {

    fun data(): LiveData<Resource<List<NewsResponse>, ResourceError>> =
        repo.getNewsList()
}