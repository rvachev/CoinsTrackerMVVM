package com.example.examapplication.presentation

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.examapplication.repository.DatabaseRepository
import com.example.examapplication.repository.entities.Data

class CardViewModel(context: Context): ViewModel() {

    private val repository = DatabaseRepository().getInstance(context)

    fun getCoinById(id: String): LiveData<Data> = repository!!.coinDao().getById(id)

}