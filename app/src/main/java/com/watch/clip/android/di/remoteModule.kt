package com.watch.clip.android.di

import com.watch.clip.android.api.ApiService
import com.watch.clip.android.api.ServiceGenerator
import com.watch.clip.android.utils.LiveNetworkMonitor
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