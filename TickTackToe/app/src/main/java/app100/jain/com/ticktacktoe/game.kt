package app100.jain.com.ticktacktoe

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class game : AppCompatActivity(), View.OnClickListener{
    override fun onClick(v: View?) {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
    }
}
