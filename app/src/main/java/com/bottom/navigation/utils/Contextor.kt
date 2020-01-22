package com.bottom.navigation.utils

import android.annotation.SuppressLint
import android.content.Context

class Contextor {

    fun init (c: Context) {
        context = c
    }

    companion object {
        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context
    }
}