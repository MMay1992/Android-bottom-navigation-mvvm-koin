package com.bottom.navigation.di

import com.bottom.navigation.api.repo.HomeRepo
import com.bottom.navigation.api.repo.NewRepo
import com.bottom.navigation.ui.feed.FeedViewModel
import com.bottom.navigation.ui.home.HomeViewModel
import com.bottom.navigation.ui.inbox.InboxViewModel
import com.bottom.navigation.ui.main.MainViewModel
import com.bottom.navigation.ui.me.MeViewModel
import com.bottom.navigation.ui.notification.NotificationViewModel
import com.bottom.navigation.ui.wallet.WalletViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val appModule = module {

    single { NewRepo(get(named("DEFAULT"))) }
    viewModel { MainViewModel(get()) }

    single { HomeRepo(get(named("DEFAULT"))) }
    viewModel { HomeViewModel(get()) }
    viewModel { WalletViewModel() }
    viewModel { FeedViewModel() }
    viewModel { InboxViewModel() }
    viewModel { MeViewModel() }
    viewModel { NotificationViewModel() }

}