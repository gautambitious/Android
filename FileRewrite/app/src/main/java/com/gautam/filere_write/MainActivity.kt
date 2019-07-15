package com.gautam.filere_write

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i("bro","Files dr ${filesDir.path}")
        val file=File(filesDir,"myfile.text")
        btn.setOnClickListener {
//            file.writeText(editText.text.toString())
            file.appendText(editText.text.toString())
            editText.setText("")
            Log.i("files","Exists= ${file.exists()}")
        }

        restoreBtn.setOnClickListener{
            val existingFile=file.readText()
            editText.setText(existingFile)
        }
    }
}
