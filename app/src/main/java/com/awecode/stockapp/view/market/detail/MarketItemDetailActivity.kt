package com.awecode.stockapp.view.market.detail

import android.os.Bundle
import com.awecode.stockapp.R
import com.awecode.stockapp.model.Indice
import com.awecode.stockapp.view.base.BaseActivity

class MarketItemDetailActivity : BaseActivity() {

    companion object {
        val INTENT_DATA = "intent_data"
    }

    override val layoutId: Int = R.layout.activity_market_item

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val indice = intent.getParcelableExtra<Indice>(INTENT_DATA)
        requireNotNull(indice) { finish() }
        changeFragment(MarketItemDetailFragment.newInstance(indice), addToBackStack = false)

    }


}
