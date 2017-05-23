package com.awecode.stockapp.view.home.market.indices

import com.awecode.stockapp.R
import com.awecode.stockapp.view.base.BaseFragment
import com.awecode.stockapp.view.home.market.MarketFragment

/**
 * Created by munnadroid on 5/23/17.
 */
class IndicesFragment : BaseFragment() {

    companion object {
        fun newInstance(): IndicesFragment {
            return IndicesFragment()
        }
    }

    override val layoutId: Int = R.layout.fragment_indices;
}