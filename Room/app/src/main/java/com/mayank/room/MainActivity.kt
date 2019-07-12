package com.mayank.room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.lifecycle.Observer
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val db by lazy {
        Room.databaseBuilder(this,
            AppDatabase::class.java,
            "todo.db")
            .allowMainThreadQueries() // to run small queries on main thread
            .fallbackToDestructiveMigration() //it avoids the crash when updated the schema of the database //it deletes the user db instead of crashing the app if any migration code is not defined
            .build()
    }
    var list= arrayListOf<Todo>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val adapter = TaskAdapter(list)
        db.todoDao().getAllTask().observe(this, Observer {
            list=it as ArrayList<Todo>
            adapter.updateTasks(list)
        })

        listView.adapter = adapter
        adapter.listItemClickListener = object : ListItemClickListener {
            override fun lisitemClick(task: Todo, position: Int) {

                db.todoDao().deleteTask(task)
//                list = db.todoDao().getAllTask() as ArrayList<Todo>
//                adapter.updateTasks(list)
            }

        }

        button.setOnClickListener {
            db.todoDao().insertRow(
                Todo(
                    task = textView.text.toString(),
                    status = false
                )
            )
//            list = db.todoDao().getAllTask() as ArrayList<Todo>
//            adapter.updateTasks(list)
        }
    }
}
