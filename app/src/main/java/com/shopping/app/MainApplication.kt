package com.shopping.app

import android.app.Application
import com.shopping.app.di.appModule
import com.shopping.app.di.localSourceModule
import com.shopping.app.di.remoteModule
import com.shopping.app.utils.Contextor
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