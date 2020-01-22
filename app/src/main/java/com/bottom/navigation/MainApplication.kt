package com.bottom.navigation

import android.app.Application
import com.bottom.navigation.di.appModule
import com.bottom.navigation.di.localSourceModule
import com.bottom.navigation.di.remoteModule
import com.bottom.navigation.utils.Contextor
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MainApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MainApplication)
            androidLogger()
            modules(
                listOf(
                    appModule,
                    localSourceModule,
                    remoteModule
                )
            )
        }
        Contextor().init(applicationContext)
    }
}