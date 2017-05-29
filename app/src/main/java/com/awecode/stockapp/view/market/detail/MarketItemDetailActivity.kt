package com.awecode.stockapp.view.market.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.awecode.stockapp.R
import com.awecode.stockapp.model.Indice
import com.awecode.stockapp.view.base.BaseActivity
import org.jetbrains.anko.toast

class MarketItemDetailActivity : BaseActivity() {


    override val layoutId: Int = R.layout.activity_market_item

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val indice = intent.getParcelableExtra<Indice>(INTENT_DATA)
        toast(indice.name)

    }

    companion object {

        private val INTENT_DATA = "intent_data"

        fun newIntent(context: Context, indice: Indice): Intent {
            val intent = Intent(context, MarketItemDetailActivity::class.java)
            intent.putExtra(INTENT_DATA, indice)
            return intent
        }
    }

}
