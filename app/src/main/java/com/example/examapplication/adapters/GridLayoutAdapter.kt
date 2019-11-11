package com.example.examapplication.adapters

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.examapplication.R
import com.example.examapplication.repository.entities.Data
import kotlinx.android.synthetic.main.grid_element.view.*
import java.text.DecimalFormat

class GridLayoutAdapter(private var context: Context, private val listOfCoins: List<Data>) : BaseAdapter(){

    private val formating = DecimalFormat("#.##")

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val coinContainer: View
        if(convertView == null){
            val name =  listOfCoins[position].symbol
            val price = formating.format(listOfCoins[position].priceUsd)
            val view: View = View.inflate(context, R.layout.grid_element, null)
            view.text.text = name
            view.coinCost.text = "$price$"
            coinContainer = view
        }else{
            coinContainer = convertView
        }
        return coinContainer
    }

    override fun getItem(position: Int): Any {
        return listOfCoins[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return listOfCoins.size
    }
}