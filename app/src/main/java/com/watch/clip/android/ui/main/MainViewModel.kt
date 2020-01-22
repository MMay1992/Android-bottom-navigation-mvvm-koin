package com.watch.clip.android.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.watch.clip.android.api.model.Resource
import com.watch.clip.android.api.model.ResourceError
import com.watch.clip.android.api.repo.NewRepo
import com.watch.clip.android.vo.NewsResponse

class MainViewModel(private val repo: NewRepo): ViewModel() {

    fun data(): LiveData<Resource<List<NewsResponse>, ResourceError>> =
        repo.getNewsList()
}