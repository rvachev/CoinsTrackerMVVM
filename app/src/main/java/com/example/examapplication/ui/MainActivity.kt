package com.example.examapplication.ui

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.examapplication.R
import com.example.examapplication.adapters.RecyclerViewAdapter
import com.example.examapplication.presentation.MainViewModel
import com.example.examapplication.repository.entities.Data
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val mContext = this
    private lateinit var recyclerLayoutManager: LinearLayoutManager
    private val dataList = mutableListOf<Data>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        refreshContainer.setColorSchemeResources(R.color.colorAccent)

        recyclerLayoutManager = LinearLayoutManager(mContext)
        recyclerView.apply {
            layoutManager = recyclerLayoutManager
            addItemDecoration(DividerItemDecoration(mContext, recyclerLayoutManager.orientation))
        }

        initUI()
    }

    private fun initUI() {
        val viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        refreshContainer.setOnRefreshListener {
            dataList.clear()
            viewModel.updateCoins().observe(this, Observer {
                it!!.data.forEach { coin ->
                    dataList.add(coin)
                }
                dataList.sortBy { data ->
                    data.rank
                }
                recyclerView.adapter = RecyclerViewAdapter(dataList, mContext)
                refreshContainer.isRefreshing = false
            })
        }

        viewModel.getCoins().observe(this, Observer {
            it!!.data.forEach { coin ->
                dataList.add(coin)
            }
            dataList.sortBy { data ->
                data.rank
            }
            recyclerView.adapter = RecyclerViewAdapter(dataList, mContext)
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.menu_name -> {
                dataList.sortBy { it.name }
            }
            R.id.menu_cost -> {
                dataList.sortBy { it.priceUsd }
            }
            R.id.menu_rank -> {
                dataList.sortBy { it.rank }
            }
            else -> return super.onOptionsItemSelected(item)
        }
        recyclerView.adapter = RecyclerViewAdapter(dataList, mContext)
        return true
    }
}
