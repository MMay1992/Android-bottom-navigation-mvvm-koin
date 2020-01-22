package com.bottom.navigation.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.bottom.navigation.api.model.Resource
import com.bottom.navigation.api.model.ResourceError
import com.bottom.navigation.api.repo.NewRepo
import com.bottom.navigation.vo.NewsResponse

class MainViewModel(private val repo: NewRepo): ViewModel() {

    fun data(): LiveData<Resource<List<NewsResponse>, ResourceError>> =
        repo.getNewsList()
}