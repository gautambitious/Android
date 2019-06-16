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
    var btn: Array<Button> = arrayOf()
    override fun onClick(v: View?) {
        if(v?.id==btn[0].id){
            btn[0].text=put(chance)
            turn(chance)
        }
        if(v?.id==btn[1].id){
            btn[1].text=put(chance)
            turn(chance)
        }
        if(v?.id==btn[2].id){
            btn[2].text=put(chance)
            turn(chance)
        }
        if(v?.id==btn[3].id){
            btn[3].text=put(chance)
            turn(chance)
        }
        if(v?.id==btn[4].id){
            btn[4].text=put(chance)
            turn(chance)
        }
        if(v?.id==btn[5].id){
            btn[5].text=put(chance)
            turn(chance)
        }
        if(v?.id==btn[6].id){
            btn[6].text=put(chance)
            turn(chance)
        }
        if(v?.id==btn[7].id){
            btn[7].text=put(chance)
            turn(chance)
        }
        if(v?.id==btn[8].id){
            btn[8].text=put(chance)
            turn(chance)
        }
        if(v?.id==btn[9].id){
            var i=Intent(this,game::class.java)
            i.putExtra(Key1,intent.extras.getString(Key1))
            i.putExtra(Key2,intent.extras.getString(Key2))
            startActivity(i)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        btn= arrayOf(button,button1,button2,button3,button4,button5,button6,button7,button8,button9)
        textView1.text=intent.extras.getString(Key2)
        textView.text=intent.extras.getString(Key1)
        turn(chance)
        for (i in btn.indices){
            btn[i].setOnClickListener(this)
        }
    }
    private fun turn(i: Boolean){
        if(i) {
            textView.setBackgroundColor(Color.parseColor("#FFF5AA"))
            textView1.setBackgroundColor(Color.parseColor("#ffffff"))
        }
        else {
            textView1.setBackgroundColor(Color.parseColor("#FFF5AA"))
            textView.setBackgroundColor(Color.parseColor("#ffffff"))
        }
        chance=!chance
    }
    private fun put(i: Boolean): String{
        if(i)
            return "O"
        else
            return "X"
    }
}
