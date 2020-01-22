package com.watch.clip.android.utils

import android.content.Context
import android.net.ConnectivityManager
import com.watch.clip.android.interfaces.NetworkMonitor

class LiveNetworkMonitor(private val context: Context) : NetworkMonitor {

    override fun isConnected(): Boolean {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        val activeNetwork = cm.activeNetworkInfo
        return activeNetwork != null && activeNetwork.isConnectedOrConnecting
    }
}