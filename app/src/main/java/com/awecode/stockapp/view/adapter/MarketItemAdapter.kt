package com.awecode.stockapp.view.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.awecode.stockapp.R
import com.awecode.stockapp.model.Indice
import kotlinx.android.synthetic.main.item_indices.view.*

/**
 * Created by munnadroid on 5/26/17.
 */

class MarketItemAdapter(val indiceList: List<Indice>, val itemClick: (Indice) -> Unit) :
        RecyclerView.Adapter<MarketItemAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_indices, parent, false)
        return ViewHolder(view, itemClick)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindForecast(indiceList[position])
    }

    override fun getItemCount() = indiceList.size


    class ViewHolder(view: View, val itemClick: (Indice) -> Unit) : RecyclerView.ViewHolder(view) {

        fun bindForecast(indice: Indice) {
            with(indice) {
                itemView.nameTextView.text = indice.name
                itemView.setOnClickListener { itemClick(this) }
            }
        }
    }
}