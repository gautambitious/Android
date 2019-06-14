package app100.jain.com.calc2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() , View.OnClickListener{
    lateinit var one: Button
    lateinit var two:Button
    lateinit var three:Button
    lateinit var four:Button
    lateinit var five:Button
    lateinit var six:Button
    lateinit var seven:Button
    lateinit var eight:Button
    lateinit var nine:Button
    lateinit var zero:Button
    lateinit var plus:Button
    lateinit var minus:Button
    lateinit var divide:Button
    lateinit var multiply:Button
    lateinit var decimal:Button
    lateinit var calc:Button
    lateinit var c1:Button
    lateinit var c2:Button
    lateinit var t: TextView
    lateinit var e: TextView



    override fun onClick(v: View?) {
        if (v?.id == R.id.plus)
            e.text = e.text.toString() + "+"
        if (v?.id == R.id.minus)
            e.text = e.text.toString() + "-"
        if (v?.id == R.id.divide)
            e.text = (e.text.toString() + "/")
        if (v?.id == R.id.multiply)
            e.text = e.text.toString() + "*"

        if (v?.id == R.id.one)
            e.text = e.text.toString() + "1"

        if (v?.id == R.id.two)
            e.text = e.text.toString() + "2"

        if (v?.id == R.id.three)
            e.text = e.text.toString() + "3"

        if (v?.id == R.id.four)
            e.text = e.text.toString() + "4"

        if (v?.id == R.id.five)
            e.text = e.text.toString() + "5"

        if (v?.id == R.id.six)
            e.text = e.text.toString() + "6"
        if (v?.id == R.id.seven)
            e.text = e.text.toString() + "7"
        if (v?.id == R.id.eight)
            e.text = e.text.toString() + "8"

        if (v?.id == R.id.nine)
            e.text = e.text.toString() + "9"
        if (v?.id == R.id.decimal)
            e.text = e.text.toString() + "."
        if (v?.id == R.id.zero)
            e.text = e.text.toString() + "0"
        if (v?.id == R.id.calc)
            t.text = solution.calculate(e.text.toString()).toString()

        if (v?.id == R.id.clear){
            e.text = ""
        t.text=""}
        if (v?.id==R.id.back) {
            e.text=e.text.toString().substring(0,e.text.toString().length-1)
        }

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        one = findViewById(R.id.one)
        two = findViewById(R.id.two)
        three = findViewById(R.id.three)
        four = findViewById(R.id.four)
        five = findViewById(R.id.five)
        six = findViewById(R.id.six)
        seven = findViewById(R.id.seven)
        eight = findViewById(R.id.eight)
        nine = findViewById(R.id.nine)
        decimal = findViewById(R.id.decimal)
        zero = findViewById(R.id.zero)
        plus = findViewById(R.id.plus)
        minus = findViewById(R.id.minus)
        multiply = findViewById(R.id.multiply)
        divide = findViewById(R.id.divide)
        calc = findViewById(R.id.calc)
        t = findViewById(R.id.textView)
        e = findViewById(R.id.editText)
        c1 = findViewById(R.id.clear)
        c2 = findViewById(R.id.back)
        one.setOnClickListener(this)
        two.setOnClickListener(this)
        three.setOnClickListener(this)
        four.setOnClickListener(this)
        five.setOnClickListener(this)
        six.setOnClickListener(this)
        seven.setOnClickListener(this)
        eight.setOnClickListener(this)
        nine.setOnClickListener(this)
        zero.setOnClickListener(this)
        plus.setOnClickListener(this)
        multiply.setOnClickListener(this)
        minus.setOnClickListener(this)
        divide.setOnClickListener(this)
        decimal.setOnClickListener(this)
        calc.setOnClickListener(this)
        c1.setOnClickListener(this)
        c2.setOnClickListener(this)
    }
}
