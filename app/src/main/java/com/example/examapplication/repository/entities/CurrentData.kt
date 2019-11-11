package com.example.examapplication.repository.entities

import com.google.gson.annotations.SerializedName

data class CurrentData(
    @SerializedName("data")
    val data: List<Data>,
    val timestamp: Long
)