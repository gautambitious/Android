package com.mayank.room

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = arrayOf(Todo::class),version = 1)
abstract class AppDatabase: RoomDatabase(){
    abstract fun todoDao(): TodoDao
}