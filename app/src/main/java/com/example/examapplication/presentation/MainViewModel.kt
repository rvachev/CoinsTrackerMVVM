package com.example.examapplication.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.examapplication.repository.CoinRepository
import com.example.examapplication.repository.entities.CurrentData
import kotlinx.coroutines.Dispatchers

class MainViewModel : ViewModel() {

    private var response: LiveData<CurrentData?>? = null

    /*fun getCoins() = liveData(Dispatchers.IO) {
        val responseList = CoinRepository.getCoins(20)

        emit(responseList)
    }*/

    fun getCoins(): LiveData<CurrentData?>?{
        response?.let {
            return response
        } ?: run {
            response = liveData(Dispatchers.IO) {
                val responseList = CoinRepository.getCoins(20)
                emit(responseList)
            }
            return response
        }
    }

}