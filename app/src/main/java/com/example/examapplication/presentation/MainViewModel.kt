package com.example.examapplication.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.examapplication.repository.CoinRepository
import kotlinx.coroutines.Dispatchers

class MainViewModel: ViewModel() {

    private val coinRepository = CoinRepository()

    fun getCoins() = liveData(Dispatchers.IO){
        val responseList = coinRepository.getCoins(10)

       emit(responseList)
    }

}