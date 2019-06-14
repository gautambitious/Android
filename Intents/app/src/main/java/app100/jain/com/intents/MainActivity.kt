package app100.jain.com.intents

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*

val Key1 = "value1"

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var b1:Button
    lateinit var et:EditText
    override fun onClick(v: View?) {
//        val i = Intent(this, Main2Activity::class.java)
//        i.putExtra(Key1, et.text.toString())
//        startActivity(i)
//        val i=Intent(Intent.ACTION_DIAL,Uri.parse("tel:${et.text}"))
        val i= Intent(Intent.ACTION_VIEW,Uri.parse("mailto:${et.text.toString()}"))
        i.putExtra(Intent.EXTRA_SUBJECT,"ffewfeokfn")
        startActivity(Intent.createChooser(i,"Send Email!"))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        b1=btn1
        et=editText
        b1.setOnClickListener(this)
    }

}
