package com.bottom.navigation.api.interceptor

import com.bottom.navigation.utils.LiveNetworkMonitor
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

class NetworkInterceptor(private val networkMonitor: LiveNetworkMonitor): Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        if (networkMonitor.isConnected()) {
            return chain.proceed(chain.request())
        } else {
            throw IOException("Internet is not stable.")
        }
    }

}