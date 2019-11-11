package com.example.examapplication.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.examapplication.R

class CardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_card)

        val coinId = intent.getStringExtra("cardId")
        initUI(coinId)
    }

    fun initUI(id: String){

    }
}
