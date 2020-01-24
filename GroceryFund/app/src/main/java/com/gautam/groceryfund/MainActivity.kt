package com.gautam.groceryfund

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        SwipeLayout.setOnRefreshListener {
            textView.text = "Nigga gay"
            SwipeLayout.isRefreshing = false
        }

    }
}
