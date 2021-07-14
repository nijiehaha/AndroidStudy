package com.example.databasetest

import android.app.Application
import android.content.Context

class App: Application() {

    companion object {
        private const val TAG = "App"
        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()
        context = this

    }

}