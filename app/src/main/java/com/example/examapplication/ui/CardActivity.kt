package com.example.examapplication.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.examapplication.R
import com.example.examapplication.presentation.CardViewModel
import kotlinx.android.synthetic.main.activity_card.*
import java.text.DecimalFormat

class CardActivity : AppCompatActivity() {

    private val formating = DecimalFormat("#.##")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_card)

        val coinId = intent.getStringExtra("cardId")
        initUI(coinId)
    }

    fun initUI(id: String){
        val viewModel = ViewModelProviders.of(this).get(CardViewModel::class.java)

        viewModel.getCoinById(id).observe(this, Observer {data ->
            cryptoName.text = data.name + " - " + data.symbol
            cryptoPrice.text = formating.format(data.priceUsd)
            cryptoChange.text = formating.format(data.changePercent24Hr)
            if (data.changePercent24Hr > 0.0){
                growImage.visibility = View.VISIBLE
                growImage.setImageResource(R.drawable.ic_grow_up)
            }else if (data.changePercent24Hr < 0.0){
                growImage.visibility = View.VISIBLE
                growImage.setImageResource(R.drawable.ic_grow_down)
            }else{
                growImage.visibility = View.INVISIBLE
            }
        })


    }
}
