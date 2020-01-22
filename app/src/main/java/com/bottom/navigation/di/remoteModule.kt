package com.bottom.navigation.di

import com.bottom.navigation.api.ApiService
import com.bottom.navigation.api.ServiceGenerator
import com.bottom.navigation.utils.LiveNetworkMonitor
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