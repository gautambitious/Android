package app100.jain.com.asynctasks

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener{
    override fun onClick(v: View?) {
        wait(10)
        clParent.setBackgroundColor(Color.BLUE)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        changeColorBtn.setOnClickListener(this)
    }
    fun wait1sec(){
        val start=System.currentTimeMillis()
        while(System.currentTimeMillis()<start+1000);
    }
    fun wait(n:Int){
        for(i in 0..n){
            wait1sec()
        }

    }
}
