package com.gautam.gmailapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        send.setOnClickListener{

                try {
                    val sender =GMailSender("bennettdigitalcourierdesk@gmail.com", "niggerfuck")
                    sender.sendMail("This is Subject",
                        "This is Body",
                        "bennettdigitalcourierdesk@gmail.com",
                        "mvgt.gautam@gmail.com")
                    Log.e("workk","damnn shit works")
                } catch (e: Exception) {
                    Log.e("workk", e.toString())
                }
        }

    }
}
