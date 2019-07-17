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
    }
}
class Todo{
    var text:String =""
    var time:String=""
}
