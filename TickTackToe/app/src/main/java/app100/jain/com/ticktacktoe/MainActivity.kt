package app100.jain.com.ticktacktoe

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

val Key1:String="b0os"
val Key2:String="b0os1"
class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onClick(v: View?) {
    var i=Intent(this,game::class.java)
        if(editText.text.toString().equals("") || editText1.text.toString().equals("")){
            Toast.makeText(this,"Player name can't be Empty",Toast.LENGTH_SHORT).show()
        }
        else{
       i.putExtra(Key1,editText.text.toString())
        i.putExtra(Key2,editText1.text.toString())
        startActivity(i)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button.setOnClickListener(this)
    }
}
