package com.example.examapplication.repository.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.examapplication.repository.entities.Data

//Functions for using DB
@Dao
interface CoinDao{

    @Query("SELECT * FROM coins")
    fun getAll(): LiveData<List<Data>>

    @Query("SELECT * FROM coins WHERE id = :id")
    fun getById(id: String): LiveData<Data>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addList(list: List<Data>)

    @Update
    fun updateAll(list: List<Data>)
}