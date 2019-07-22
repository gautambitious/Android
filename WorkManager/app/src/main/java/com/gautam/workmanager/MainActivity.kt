package com.gautam.workmanager

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.work.Constraints
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nm= getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            nm.createNotificationChannel(NotificationChannel("first","default",NotificationManager.IMPORTANCE_HIGH))
        }
        requestOneTimeAsk()
    }
    private fun requestOneTimeAsk(){

        val constraints= Constraints.Builder().apply {
            setRequiredNetworkType(NetworkType.UNMETERED)
            setRequiresCharging(true)
            setRequiresDeviceIdle(false)
            setRequiresStorageNotLow(true)
        }.build()

        val workRequest = OneTimeWorkRequestBuilder<NotificationWorker>()
            .setInitialDelay(20,TimeUnit.SECONDS)
            .build()

        WorkManager.getInstance(this).enqueue(workRequest)
    }
}
