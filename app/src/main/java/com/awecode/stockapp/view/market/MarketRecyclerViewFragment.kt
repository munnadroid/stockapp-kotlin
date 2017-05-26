package com.awecode.stockapp.view.market

import com.awecode.stockapp.R
import com.awecode.stockapp.view.base.BaseFragment

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
}