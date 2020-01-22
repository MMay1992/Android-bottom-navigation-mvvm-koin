package com.shopping.app.di

import com.shopping.app.api.repo.NewRepo
import com.shopping.app.ui.feed.FeedViewModel
import com.shopping.app.ui.home.HomeViewModel
import com.shopping.app.ui.inbox.InboxViewModel
import com.shopping.app.ui.main.MainViewModel
import com.shopping.app.ui.me.MeViewModel
import com.shopping.app.ui.notification.NotificationViewModel
import com.shopping.app.ui.wallet.WalletViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val appModule = module {

    single { NewRepo(get(named("DEFAULT"))) }
    viewModel { MainViewModel(get()) }

    viewModel { HomeViewModel() }
    viewModel { WalletViewModel() }
    viewModel { FeedViewModel() }
    viewModel { InboxViewModel() }
    viewModel { MeViewModel() }
    viewModel { NotificationViewModel() }

}