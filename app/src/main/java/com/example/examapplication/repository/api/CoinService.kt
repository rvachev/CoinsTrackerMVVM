package com.example.examapplication.repository.api

import com.example.examapplication.repository.entities.CurrentData
import retrofit2.http.GET
import retrofit2.http.Query

interface CoinService {

    @GET("/v2/assets")
    suspend fun getAllCoins(@Query("limit") limit: Int): CurrentData
}