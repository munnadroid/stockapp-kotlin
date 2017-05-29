package com.awecode.stockapp.view.market.detail

import android.os.Bundle
import android.view.View
import com.awecode.stockapp.R
import com.awecode.stockapp.model.Indice
import com.awecode.stockapp.view.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_market_item_detail_fragment.*

/**
 * Created by munnadroid on 5/28/17.
 */
class MarketItemDetailFragment : BaseFragment() {

    override val layoutId: Int = R.layout.fragment_market_item_detail_fragment

    companion object {
        fun newInstance(indice: Indice): MarketItemDetailFragment {
            val fragment = MarketItemDetailFragment();
            fragment.setData(indice)
            return fragment
        }
    }

    private var mIndice: Indice? = null

    private fun setData(indice: Indice) {
        this.mIndice = indice
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        textView1.text = mIndice?.name

    }
}