package com.gautam.javamail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            val jm=JavaMailAPI(this,"mvgt.gautam@gmail.com","check","kdnskndssadsds")
            jm.execute()
        }

    }
}
