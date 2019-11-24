package com.example.examapplication.repository.dbs

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.examapplication.repository.dao.CoinDao
import com.example.examapplication.repository.entities.Data

//Our main DB
@Database(entities = [(Data::class)], version = 1)
abstract class MainDataBase: RoomDatabase(){

    abstract fun coinDao(): CoinDao

}