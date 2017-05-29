package com.awecode.stockapp.view.market

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.awecode.stockapp.R
import com.awecode.stockapp.model.Indice
import com.awecode.stockapp.util.extensions.launchActivity
import com.awecode.stockapp.view.adapter.MarketItemAdapter
import com.awecode.stockapp.view.base.BaseFragment
import com.awecode.stockapp.view.market.detail.MarketItemDetailActivity
import kotlinx.android.synthetic.main.fragment_market_recyclerview.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

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

    /**
     * request api and populate in list in view
     */
    fun setupListAdapter() = doAsync {
        var indices = getDummyList()
        uiThread {
            recyclerView.layoutManager = LinearLayoutManager(activity)
            val adapter = MarketItemAdapter(indices) {
                //start detail view activity
                //startActivity(MarketItemDetailActivity.newIntent(context, it))
                activity.launchActivity<MarketItemDetailActivity>{
                    putExtra(MarketItemDetailActivity.INTENT_DATA,it)
                }
            }
            recyclerView.adapter = adapter
        }

    }


    fun getDummyList(): List<Indice> {
        var indices = ArrayList<Indice>()
        (0..10).mapTo(indices) { Indice("Dow$it", 2300.0, 1300.0, 4300.0, 5300.0, "23/12/2017", "NEPSE") }

        return indices
    }


}