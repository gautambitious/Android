package app100.jain.com.layouts


import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout

import android.widget.LinearLayout.*
import android.widget.LinearLayout.LayoutParams.*
import android.widget.LinearLayout.LayoutParams.MATCH_PARENT as MATCH_PARENT1

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var ll: LinearLayout
    var iv = arrayOfNulls<ImageView>(3)
    override fun onClick(v: View) {

    }

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ll = LinearLayout(this)
        ll.orientation = VERTICAL
        ll.layoutParams= ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        for (i in 0..3) {
            iv[i] = ImageView(this)
            iv[i]?.setImageResource(R.drawable.a)
            iv[i]?.layoutParams = LayoutParams(
                WRAP_CONTENT,
                WRAP_CONTENT,
                1.0f
            )
            ll.addView(iv[i])
        }
        //setContentView(R.layout.activity_main);

        setContentView(ll)
    }
}
