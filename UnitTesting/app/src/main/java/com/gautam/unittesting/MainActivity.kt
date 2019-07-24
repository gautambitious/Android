package com.gautam.unittesting

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button.setOnClickListener {
            val km=text1.text.toString().toFloat()
            val min=text2.text.toString().toInt()
            textView.text=CalciFareUtil.calculateFare(km,min).toString()
        }
    }

}
