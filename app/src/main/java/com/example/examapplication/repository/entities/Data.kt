package com.example.examapplication.repository.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "coins")
data class Data(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: String,

    @ColumnInfo(name = "rank")
    val rank: Int,

    @ColumnInfo(name = "symbol")
    val symbol: String,

    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "priceUsd")
    val priceUsd: Double,

    @ColumnInfo(name = "changePercent24Hr")
    val changePercent24Hr: Double
)