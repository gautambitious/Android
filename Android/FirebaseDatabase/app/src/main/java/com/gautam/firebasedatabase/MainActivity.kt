package com.gautam.firebasedatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
val db by lazy{
    FirebaseDatabase.getInstance().reference
}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val ref=db.child("messages/user1")
        db.child("messages")
            .child("user1")
            .addChildEventListener(object : ChildEventListener {
                override fun onCancelled(p0: DatabaseError) {

                }

                override fun onChildMoved(p0: DataSnapshot, p1: String?) {

                }

                override fun onChildChanged(p0: DataSnapshot, p1: String?) {

                }

                override fun onChildAdded(p0: DataSnapshot, p1: String?) {
                    textView.append(" ${p0.getValue(Todo::class.java)?.text}")
//                    to get value of the key use:
//                    p0.key
                }

                override fun onChildRemoved(p0: DataSnapshot) {

                }

            })
//            .addValueEventListener(object :ValueEventListener{
//                override fun onCancelled(p0: DatabaseError) {
//
//                }
//
//                override fun onDataChange(p0: DataSnapshot) {
//                    textView.text=p0.getValue(Todo::class.java)?.text
//                }
//
//            })
        button.setOnClickListener {
            val todo = Todo()
            todo.text = editText.text.toString()
            todo.time = System.currentTimeMillis().toString()
            val key = ref.push().key
            ref.child(key!!).setValue(todo)
            editText.setText("")

        }
    }
}
class Todo{
    var text:String =""
    var time:String=""
}
