package com.awecode.stockapp.view.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.awecode.stockapp.R
import com.awecode.stockapp.model.ShareItem
import kotlinx.android.synthetic.main.item_share_calculation.view.*

/**
 * Created by munnadroid on 5/26/17.
 */

class ShareCalcListAdapter(val dataList: List<ShareItem>, val itemClick: (ShareItem) -> Unit) :
        RecyclerView.Adapter<ShareCalcListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_share_calculation, parent, false)
        return ViewHolder(view, itemClick)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindForecast(dataList[position])
    }

    override fun getItemCount() = dataList.size


    class ViewHolder(view: View, val itemClick: (ShareItem) -> Unit) : RecyclerView.ViewHolder(view) {

        fun bindForecast(data: ShareItem) {
            with(data) {
                itemView.labelTextView.text = data.label
                itemView.amountTextView.text = "Rs ${data.amount}"
                itemView.setOnClickListener { itemClick(this) }
            }
        }
    }
}