package com.awecode.stockapp.view.market

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.awecode.stockapp.R
import com.awecode.stockapp.view.adapter.MarketItemAdapter
import com.awecode.stockapp.view.base.BaseFragment
import com.awecode.stockapp.view.model.Indices
import kotlinx.android.synthetic.main.fragment_market_recyclerview.*
import org.jetbrains.anko.toast

/**
 * Created by munnadroid on 5/23/17.
 */
class MarketRecyclerViewFragment : BaseFragment() {

    private var mMarketViewType: MarketFragment.MarketViewType? = null

    private fun setMarketViewType(marketViewType: MarketFragment.MarketViewType) {
        this.mMarketViewType = marketViewType
    }

    companion object {

        fun newInstance(marketViewType: MarketFragment.MarketViewType): MarketRecyclerViewFragment {
            val market = MarketRecyclerViewFragment()
            market.setMarketViewType(marketViewType)
            return market
        }
    }

    override val layoutId: Int = R.layout.fragment_market_recyclerview

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupListAdapter()
    }

    fun setupListAdapter() {
        recyclerView.layoutManager = LinearLayoutManager(activity)
        val adapter = MarketItemAdapter(getDummyList()) {
            activity.toast("testing click")
        }
        recyclerView.adapter = adapter
    }

    fun getDummyList(): List<Indices> {
        var indices = ArrayList<Indices>()
        (0..10).mapTo(indices) { Indices("Dow$it", 2300.0, 1300.0, 4300.0, 5300.0, "23/12/2017", "NEPSE") }

        return indices
    }


}