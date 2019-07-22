package com.gautam.workmanager


import android.app.NotificationManager
import android.content.Context
import androidx.core.app.NotificationCompat
import androidx.work.Worker
import androidx.work.WorkerParameters

class NotificationWorker(val context:Context,workParams: WorkerParameters) : Worker(context,workParams){
    override fun doWork(): Result {
        val nm =context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        val notification = NotificationCompat.Builder(context,"first").apply {
            setContentTitle("Background Task")
            setContentText("Simple Notification")
            setSmallIcon(R.drawable.ic_launcher_foreground)
            priority=NotificationManager.IMPORTANCE_MAX
        }.build()
        nm.notify(System.currentTimeMillis().toInt(),notification)
        return Result.success()
    }

}