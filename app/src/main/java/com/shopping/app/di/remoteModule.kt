package com.shopping.app.di

import com.shopping.app.api.ApiService
import com.shopping.app.api.ServiceGenerator
import com.shopping.app.utils.LiveNetworkMonitor
import org.koin.android.ext.koin.androidContext
import org.koin.core.qualifier.named
import org.koin.dsl.module

val remoteModule = module {
    single { LiveNetworkMonitor(androidContext()) }
    factory(named("DEFAULT")) { ServiceGenerator.create(
        get(),
        ApiService::class.java
    ) }
}