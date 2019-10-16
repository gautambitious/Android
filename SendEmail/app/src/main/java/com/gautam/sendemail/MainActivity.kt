package com.gautam.sendemail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import java.lang.Exception
import java.util.*
import android.os.Looper
import android.os.Handler


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val handler = Handler(Looper.getMainLooper())
        handler.post(Runnable {
            sendMailUsingSendGrid(
                "digitalcourierdesk@gmail.com", "mvgt.gautam@gmail.com",
                "This is the test subject",
                "This is mail body send using sendgrid :)"
            )

            Toast.makeText(applicationContext, "Sending mail...", Toast.LENGTH_SHORT).show()
        })

    }
    private fun sendMailUsingSendGrid(from: String, to: String, subject: String, mailBody: String) {
        val params = Hashtable<String,String>()
        params.put("to", to)
        params.put("from", from)
        params.put("subject", subject)
        params.put("text", mailBody)

        val email = SendGridAsyncTask()
        try {
            email.execute(params)
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }
}

