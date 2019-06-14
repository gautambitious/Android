package app100.jain.com.intents

import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import android.support.v7.app.AppCompatActivity;
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity() , View.OnClickListener{
    override fun onClick(v: View?) {
        val connectService = this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if(connectService.activeNetworkInfo.isConnected)
            tv.text="connected"
        else
            tv.text="Dissconnected"
    }

    lateinit var tv:TextView
    lateinit var b1:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        var name = intent.getStringExtra(Key1)
        tv=textView
        b1=button
        b1.setOnClickListener(this)
        tv.text=name
        }
    }
