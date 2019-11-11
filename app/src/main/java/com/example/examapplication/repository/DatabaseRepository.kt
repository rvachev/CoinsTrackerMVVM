package com.example.examapplication.repository

import android.content.Context
import androidx.room.Room
import com.example.examapplication.repository.dbs.MainDataBase

class DatabaseRepository{

    private var instance: MainDataBase? = null

    fun getInstance(context: Context): MainDataBase?{
        if(instance == null){
            synchronized(this){
                if(instance == null){
                    instance = Room.databaseBuilder(context.applicationContext,
                        MainDataBase::class.java, "main")
                        .build()
                }
            }
        }
        return instance
    }
}