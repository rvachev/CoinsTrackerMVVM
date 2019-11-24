package com.example.examapplication.ui

import android.annotation.SuppressLint
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

    @SuppressLint("StringFormatInvalid")
    fun initUI(id: String) {
        val viewModel = ViewModelProviders.of(this).get(CardViewModel::class.java)

        val resource = resources
        viewModel.getCoin(id)?.observe(this, Observer { data ->
            cryptoName.text =
                String.format(resource.getString(R.string.name), data.name, data.symbol)
            cryptoPrice.text =
                String.format(resource.getString(R.string.price), formating.format(data.priceUsd))
            cryptoChange.text = String.format(
                resource.getString(R.string.changing),
                formating.format(data.changePercent24Hr)
            )
            if (data.changePercent24Hr >= 0.0) {
                growImage.setImageResource(R.drawable.ic_grow_up)
            } else {
                growImage.setImageResource(R.drawable.ic_grow_down)
            }
        })


    }
}
