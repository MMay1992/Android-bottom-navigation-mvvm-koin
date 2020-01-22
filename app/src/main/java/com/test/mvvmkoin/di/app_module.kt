package com.test.mvvmkoin.di

import com.test.mvvmkoin.api.repo.NewRepo
import com.test.mvvmkoin.ui.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val appModule = module {

    single { NewRepo(get(named("DEFAULT"))) }
    viewModel { MainViewModel(get()) }

}