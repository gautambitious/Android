package app100.jain.com.fragments

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;
import android.view.Menu
import android.view.MenuItem
import android.view.View

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener{
    override fun onClick(v: View?) {
        if (v?.id==R.id.marvelBtn1)
            supportFragmentManager.beginTransaction().replace(R.id.container,marvelFragment()).commit()
        else
            supportFragmentManager.beginTransaction().replace(R.id.container,fragmentDc()).commit()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        marvelBtn1.setOnClickListener(this)
        dcbtn.setOnClickListener(this)
    }
}
