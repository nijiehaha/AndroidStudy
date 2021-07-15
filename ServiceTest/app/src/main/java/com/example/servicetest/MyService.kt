package com.example.servicetest

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.Binder
import android.os.Build
import android.os.IBinder
import android.util.Log
import androidx.core.app.NotificationCompat
import kotlin.concurrent.thread

class MyService : Service() {

    private val mBinder = DownloadBinder()

    class DownloadBinder: Binder() {
        fun startDownload(){
            Log.d(TAG, "startDownload: executed")
        }
        fun getProgress(): Int {
            Log.d(TAG, "getProgress: executed")
            return  0
        }
    }

    companion object {
        private const val TAG = "MyService"
    }

    override fun onCreate() {
        super.onCreate()
        Log.d(TAG, "onCreate: executed")

        val manager = getSystemService(Context.NOTIFICATION_SERVICE)
                as NotificationManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel("my_service",
                "前台 service 通知",
                NotificationManager.IMPORTANCE_DEFAULT)
            manager.createNotificationChannel(channel)
        }

        val intent = Intent(this, MainActivity::class.java)
        val pi = PendingIntent.getActivity(this, 0, intent, 0)
        val notification = NotificationCompat.Builder(this, "my_service")
            .setContentTitle("this is content title")
            .setContentText("this is content text")
            .setSmallIcon(R.drawable.ic_launcher_background)
            .setContentIntent(pi)
            .build()

        startForeground(1, notification)

    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        thread {
            //
            stopSelf()
        }

        return super.onStartCommand(intent, flags, startId)
        Log.d(TAG, "onStartCommand: executed")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: executed")
    }

    override fun onBind(intent: Intent): IBinder {
        return mBinder
    }

}