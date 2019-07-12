package com.mayank.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TodoDao {
// why we use interface- think
    @Insert
    fun insertRow(task:Todo)

    @Insert
    fun insertMultiple(tasklist:ArrayList<Todo>)

    @Query("Select * FROM Todo")
    fun getAllTask() : List<Todo>

    @Query("Select * FROM Todo Where status = :done")
    fun getAllDoneTask(done:Boolean) : List<Todo>

    @Delete
    fun deleteTask(task : Todo)
}