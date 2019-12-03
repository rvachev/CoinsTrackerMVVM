package com.example.examapplication.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.examapplication.repository.CoinRepository
import com.example.examapplication.repository.entities.Data
import kotlinx.coroutines.Dispatchers

class CardViewModel : ViewModel() {

    private var response: LiveData<Data>? = null

    /*fun getCoin(id: String) = liveData(Dispatchers.IO) {
        val coin = CoinRepository.getCoins(20)

        val filter = coin!!.data.single {
            it.name == id
        }
        emit(filter)
    }*/

    fun getCoin(id: String): LiveData<Data>?{
        response?.let{
            return response
        } ?: run{
            response = liveData(Dispatchers.IO) {
                val coin = CoinRepository.getCoins(100)

                val filter = coin.data.single{
                    it.name == id
                }

                emit(filter)
            }
            return response
        }
    }

}