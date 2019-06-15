package app100.jain.com.ticktacktoe

import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_game.*

class game : AppCompatActivity(), View.OnClickListener{
    var chance=true
    val btn: Array<Button> = arrayOf(button,button1,button2,button3,button4,button5,button6,button7,button8)
    override fun onClick(v: View?) {
        if(chance)
            
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        textView1.text=intent.extras.getString(Key2)
        textView.text=intent.extras.getString(Key1)
        turn(chance)
        for (i in btn.indices){
            btn[i].setOnClickListener(this)
        }
    }
    private fun turn(i: Boolean){
        if(i)
            textView.setBackgroundColor(Color.parseColor("#FFF5AA"))
        else
            textView1.setBackgroundColor(Color.parseColor("#FFF5AA"))
    }
}
