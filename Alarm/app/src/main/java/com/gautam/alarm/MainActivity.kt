package com.gautam.alarm

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
val am by lazy{
    getSystemService(Context.ALARM_SERVICE) as AlarmManager
}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val intent=Intent(this,MainActivity::class.java)
        val penditIntent=PendingIntent.getActivity(this,123,intent,PendingIntent.FLAG_UPDATE_CURRENT)
//        am.setRepeating(
//            AlarmManager.RTC,
//            System.currentTimeMillis()+10000,
//            15000,
//                penditIntent
//            )
        am.set(
            AlarmManager.RTC_WAKEUP,
            System.currentTimeMillis()+20000,
            penditIntent
        )
    }
}
