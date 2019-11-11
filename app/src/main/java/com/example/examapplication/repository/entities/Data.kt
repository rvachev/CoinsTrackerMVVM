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

    @ColumnInfo(name = "supply")
    val supply: Double,

    @ColumnInfo(name = "maxSupply")
    val maxSupply: Double,

    @ColumnInfo(name = "marketCapUsd")
    val marketCapUsd: Double,

    @ColumnInfo(name = "volumeUsd24Hr")
    val volumeUsd24Hr: Double,

    @ColumnInfo(name = "priceUsd")
    val priceUsd: Double,

    @ColumnInfo(name = "changePercent24Hr")
    val changePercent24Hr: Double,

    @ColumnInfo(name = "vwap24Hr")
    val vwap24Hr: Double
)