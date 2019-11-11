package com.example.examapplication.repository.dbs

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.examapplication.repository.dao.CoinDao
import com.example.examapplication.repository.entities.Data

//Our main DB
@Database(entities = [(Data::class)], version = 1)
abstract class MainDataBase: RoomDatabase(){

    private var instance: MainDataBase? = null

    abstract fun coinDao(): CoinDao

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