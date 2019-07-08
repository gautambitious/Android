package app100.jain.com.othello

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.marginBottom
import androidx.core.view.size
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk27.coroutines.onClick
class MainActivity : AppCompatActivity(), View.OnClickListener{
    override fun onClick(v: View?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    var chance=true
    lateinit var tv:TextView
    lateinit var tv1:TextView
    var linearlt= arrayListOf<LinearLayout>()
    var btn= arrayListOf<Button>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        linearLayout(){
            orientation=LinearLayout.VERTICAL
            layoutParams=ViewGroup.LayoutParams(matchParent, matchParent)
            linearLayout(){
                weightSum=4f
                layoutParams=ViewGroup.LayoutParams(matchParent, wrapContent)
                tv=textView("Black"){
                    textSize= sp(10).toFloat()
                }.lparams(){
                    weight=1f
                }
                tv1=textView("White"){
                    textSize= sp(10).toFloat()
                    textAlignment= View.TEXT_ALIGNMENT_VIEW_END
                }.lparams(){
                    weight=3f
                }
            }
        for(i in 0..7){
            linearlt.add(linearLayout(){
                layoutParams=ViewGroup.LayoutParams(matchParent, wrapContent)
                orientation=LinearLayout.HORIZONTAL
                weightSum=8f
                for (j in 0..7){
                    btn.add(button(){
                        onClick {
                            if(check()){
                            }
                        }
                    }.lparams(width= wrapContent){
                        padding=sp(0)
                        weight=1f
                        margin=sp(0)
                    })
                }
            })
        }}

    }

    private fun check(): Boolean{
        return true
            }
    private fun turn(i: Boolean){
        if(i) {
            tv.setBackgroundColor(Color.parseColor("#FFF5AA"))
            tv1.setBackgroundColor(Color.parseColor("#ffffff"))
        }
        else {
            tv1.setBackgroundColor(Color.parseColor("#FFF5AA"))
            tv.setBackgroundColor(Color.parseColor("#ffffff"))
        }
        chance=!chance
    }
    private fun put(i: Boolean): Int{
        if(i)
            return Color.parseColor("#000000")
        else
            return Color.parseColor("#ffffff")
    }
}
