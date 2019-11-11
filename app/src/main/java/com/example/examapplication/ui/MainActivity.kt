package com.example.examapplication.ui

import android.content.Intent
import android.graphics.Point
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.examapplication.R
import com.example.examapplication.adapters.GridLayoutAdapter
import com.example.examapplication.presentation.MainViewModel
import com.example.examapplication.repository.dbs.MainDataBase
import com.example.examapplication.repository.entities.Data
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.grid_element.*

class MainActivity : AppCompatActivity() {

    private val mContext = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initUI()
    }

    private fun initUI(){
        val viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        viewModel.getCoins().observe(this, Observer {
            val dataList = mutableListOf<Data>()
            it.data.forEach {coin ->
                dataList.add(coin)
            }
            dataList.sortBy { it.rank }
            mainGridContainer.adapter = GridLayoutAdapter(mContext, dataList)
        })

        mainGridContainer.onItemClickListener = AdapterView.OnItemClickListener { parentView, _, position, _ ->
            val itemAtPosition = parentView.getItemAtPosition(position) as Data
            val intent = Intent(mContext, CardActivity::class.java)
            intent.putExtra("cardId", itemAtPosition.id)
            startActivity(intent)
        }
    }
}
