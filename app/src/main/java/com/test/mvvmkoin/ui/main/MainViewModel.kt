package com.test.mvvmkoin.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.test.mvvmkoin.api.model.Resource
import com.test.mvvmkoin.api.model.ResourceError
import com.test.mvvmkoin.api.repo.NewRepo
import com.test.mvvmkoin.vo.NewsResponse

class MainViewModel(private val repo: NewRepo): ViewModel() {

    fun data(): LiveData<Resource<List<NewsResponse>, ResourceError>> =
        repo.getNewsList()
}