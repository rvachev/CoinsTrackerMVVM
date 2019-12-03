package com.example.examapplication.repository

import com.example.examapplication.repository.api.CoinService
import com.example.examapplication.repository.entities.CurrentData
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object CoinRepository {

    private var currentData: CurrentData? = null
    private val service by lazy {
        Retrofit.Builder()
            .baseUrl("https://api.coincap.io")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinService::class.java)
    }

    suspend fun getCoins(limit: Int): CurrentData {
        currentData?.let {
            return it
        } ?: run {
            val data = service.getAllCoins(limit)
            currentData = data
            return data
        }
    }

    suspend fun updateCoins(limit: Int): CurrentData{
        currentData = service.getAllCoins(limit)
        return currentData as CurrentData
    }
}