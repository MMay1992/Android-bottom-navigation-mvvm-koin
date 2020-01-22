package com.test.mvvmkoin.di

import com.test.mvvmkoin.api.ApiService
import com.test.mvvmkoin.api.ServiceGenerator
import com.test.mvvmkoin.utils.LiveNetworkMonitor
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