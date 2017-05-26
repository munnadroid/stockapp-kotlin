package com.awecode.stockapp.view.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.awecode.stockapp.R
import com.awecode.stockapp.view.model.Indices
import kotlinx.android.synthetic.main.item_indices.view.*

/**
 * Created by munnadroid on 5/26/17.
 */

class MarketItemAdapter(val indicesList: List<Indices>, val itemClick: (Indices) -> Unit) :
        RecyclerView.Adapter<MarketItemAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_indices, parent, false)
        return ViewHolder(view, itemClick)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindForecast(indicesList[position])
    }

    override fun getItemCount() = indicesList.size


    class ViewHolder(view: View, val itemClick: (Indices) -> Unit) : RecyclerView.ViewHolder(view) {

        fun bindForecast(indice: Indices) {
            with(indice) {
                itemView.textView.text = indice.name
                itemView.setOnClickListener { itemClick(this) }
            }
        }
    }
}