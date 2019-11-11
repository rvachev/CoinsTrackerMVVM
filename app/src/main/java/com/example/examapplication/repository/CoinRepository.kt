package com.example.examapplication.repository

import com.example.examapplication.repository.api.CoinService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CoinRepository{

    private var retrofit: Retrofit? = null
    private val service = getInstance()!!.create(CoinService::class.java)

    suspend fun getCoins(limit: Int) = service.getAllCoins(limit)

    private fun getInstance(): Retrofit?{
        if(retrofit == null){
            retrofit = Retrofit.Builder()
                .baseUrl("https://api.coincap.io")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit
    }
}