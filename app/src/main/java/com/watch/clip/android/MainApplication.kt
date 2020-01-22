package com.watch.clip.android

import android.app.Application
import com.watch.clip.android.di.appModule
import com.watch.clip.android.di.localSourceModule
import com.watch.clip.android.di.remoteModule
import com.watch.clip.android.utils.Contextor
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