package com.example.examapplication.ui

import android.content.Intent
import android.graphics.Point
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.examapplication.R
import com.example.examapplication.adapters.GridLayoutAdapter
import com.example.examapplication.adapters.RecyclerViewAdapter
import com.example.examapplication.presentation.MainViewModel
import com.example.examapplication.repository.dbs.MainDataBase
import com.example.examapplication.repository.entities.Data
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.grid_element.*

class MainActivity : AppCompatActivity() {

    private val mContext = this
    private lateinit var recyclerLayoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerLayoutManager = LinearLayoutManager(mContext)
        recyclerView.apply {
            layoutManager = recyclerLayoutManager
            addItemDecoration(DividerItemDecoration(mContext, recyclerLayoutManager.orientation))
        }

        initUI()
    }

    private fun initUI() {
        val viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        viewModel.getCoins()?.observe(this, Observer {
            val dataList = mutableListOf<Data>()
            it!!.data.forEach { coin ->
                dataList.add(coin)
            }
            dataList.sortBy { data ->
                data.rank
            }
            recyclerView.adapter = RecyclerViewAdapter(dataList, mContext)
        })
    }
}
