package com.watch.clip.android.di

import com.watch.clip.android.api.repo.NewRepo
import com.watch.clip.android.ui.home.HomeViewModel
import com.watch.clip.android.ui.main.MainViewModel
import com.watch.clip.android.ui.wallet.WalletViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val appModule = module {

    single { NewRepo(get(named("DEFAULT"))) }
    viewModel { MainViewModel(get()) }

    viewModel { HomeViewModel() }
    viewModel { WalletViewModel() }

}