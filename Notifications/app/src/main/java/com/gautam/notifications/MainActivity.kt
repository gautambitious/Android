package com.gautam.notifications

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nm = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            nm.createNotificationChannel(
                NotificationChannel("first",
                "default",NotificationManager.IMPORTANCE_DEFAULT)
            )
        }
        simpleNotificationBtn.setOnClickListener {
            val simpleNotification= NotificationCompat.Builder(this,"first")
                .setContentTitle("Simple Title")
                .setContentText("This is sample description of a simple notification")
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .build()
            nm.notify(System.currentTimeMillis().toInt(),simpleNotification)
        }
        actionNotificationBtn.setOnClickListener {
            val i= Intent()
            i.action=Intent.ACTION_VIEW
            i.data= Uri.parse("https://www.google.co.in/")

            val pi=PendingIntent.getActivity(this,123,i,PendingIntent.FLAG_UPDATE_CURRENT)

            val simpleNotification= NotificationCompat.Builder(this,"first")
                .setContentTitle("Simple Title")
                .setContentText("This is sample description of a simple notification")
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentIntent(pi)
                .setOngoing(true)
                .setAutoCancel(true)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .build()
            nm.notify(System.currentTimeMillis().toInt(),simpleNotification)
        }
        otherNotificationBtn.setOnClickListener {
            val i= Intent()
            i.action=Intent.ACTION_VIEW
            i.data= Uri.parse("https://www.google.co.in/")

            val pi=PendingIntent.getActivity(this,123,i,PendingIntent.FLAG_UPDATE_CURRENT)

            val simpleNotification= NotificationCompat.Builder(this,"first")
                .setContentTitle("Simple Title")
                .setContentText("This is sample description of a simple notification")
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .addAction(R.drawable.ic_launcher_foreground,"Click me bruh",pi)
                .setOngoing(true)
                .setAutoCancel(true)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .build()
            nm.notify(System.currentTimeMillis().toInt(),simpleNotification)
        }
    }
}
