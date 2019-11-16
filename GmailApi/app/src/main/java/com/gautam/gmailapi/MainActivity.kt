package com.gautam.gmailapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.setOnClickListener {
            Log.i("SendMailActivity", "Send Button Clicked.")

            val fromEmail = editText1.text.toString()
            val fromPassword = editText2.text.toString()
            val toEmails =editText3.text.toString()
            val toEmailList = listOf(toEmails.split("\\s*,\\s*"))
            Log.i("SendMailActivity", "To List: $toEmailList")
            val emailSubject = editText4.text.toString()
            val emailBody =editText5.text.toString()
            SendMailTask(this).execute(fromEmail,
                fromPassword, toEmailList, emailSubject, emailBody)
        }

    }
}
