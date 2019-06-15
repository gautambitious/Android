package app100.jain.com.ticktacktoe

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

val Key1:String="b0os"
val Key2:String="b0os"
class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onClick(v: View?) {
    var i=Intent(this,game::class.java)
       i.putExtra(Key1,textView.text.toString())
        i.putExtra(Key2,textView1.text.toString())
        startActivity(i)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button.setOnClickListener(this)
    }
}
