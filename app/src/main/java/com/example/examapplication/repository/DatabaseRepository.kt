package com.example.examapplication.repository

import android.content.Context
import androidx.room.Room
import com.example.examapplication.repository.dbs.MainDataBase

class DatabaseRepository(private val context: Context){

    private val instance by lazy{
        Room.databaseBuilder(context.applicationContext,
            MainDataBase::class.java, "main").build()
    }
}