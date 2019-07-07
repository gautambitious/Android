package app100.jain.com.othello

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.core.view.marginBottom
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk27.coroutines.onClick
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        linearLayout(){
            orientation=LinearLayout.VERTICAL
            layoutParams=ViewGroup.LayoutParams(matchParent, matchParent)
        for(i in 0..7){
            linearLayout(){
                layoutParams=ViewGroup.LayoutParams(matchParent, wrapContent)
                orientation=LinearLayout.HORIZONTAL
                weightSum=8f
                for (j in 0..7){
                    button(){
                        onClick {
                            check()
                        }
                    }.lparams(width= wrapContent){
                        padding=sp(0)
                        weight=1f
                        margin=sp(0)
                    }
                }
            }
        }
        }}

    private fun check() {
        toast("jhbjknk")
            }
}
