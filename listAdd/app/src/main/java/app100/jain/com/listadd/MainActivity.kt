package app100.jain.com.listadd

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener{
    var list : ArrayList<String> = arrayListOf()
    lateinit var et:EditText
    lateinit var adapter: ArrayAdapter<String>
    override fun onClick(v: View?) {
        if(!et.text.toString().equals("")){
        list.add(editText.text.toString())
        update(list)
        et.setText("")}
        else
            Toast.makeText(this,"Can't be empty",Toast.LENGTH_SHORT).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,list)
        listView.adapter=adapter
        button.setOnClickListener(this)
        et=editText
    }
    private fun update(i:ArrayList<String>) {
        adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,i)
        listView.adapter=adapter
    }
}
