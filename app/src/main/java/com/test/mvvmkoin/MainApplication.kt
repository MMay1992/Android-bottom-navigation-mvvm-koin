package com.test.mvvmkoin

import android.app.Application
import com.test.mvvmkoin.di.appModule
import com.test.mvvmkoin.di.localSourceModule
import com.test.mvvmkoin.di.remoteModule
import com.test.mvvmkoin.utils.Contextor
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