package com.example.examapplication.adapters

import android.content.Context
import android.content.Intent
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.examapplication.R
import com.example.examapplication.repository.entities.Data
import com.example.examapplication.ui.CardActivity
import kotlinx.android.synthetic.main.grid_element.view.*
import java.text.DecimalFormat

class RecyclerViewAdapter(private val coinList: List<Data>, private val context: Context) :
    RecyclerView.Adapter<RecyclerViewAdapter.CoinHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CoinHolder {
        val mainView = View.inflate(context, R.layout.grid_element, null)
        return CoinHolder(mainView)
    }

    override fun getItemCount() = coinList.size

    override fun onBindViewHolder(holder: CoinHolder, position: Int) {
        val coin = coinList[position]
        holder.bindElements(coin)
    }

    class CoinHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val item: View = itemView
        private val formating = DecimalFormat("#.##")

        init {
            item.setOnClickListener {
                val context = itemView.context
                val intent = Intent(context, CardActivity::class.java)
                intent.putExtra("cardId", it.text.text)
                context.startActivity(intent)
            }
        }

        fun bindElements(coin: Data) {
            itemView.text.text = coin.name
            itemView.coinCost.text = String.format(
                item.resources.getString(R.string.price),
                formating.format(coin.priceUsd)
            )
            itemView.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        }

    }
}