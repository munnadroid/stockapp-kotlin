package com.awecode.stockapp.view.tools

import android.os.Bundle
import android.view.View
import com.awecode.stockapp.R
import com.awecode.stockapp.view.base.BaseFragment


class IPOCostCalculatorFragment : BaseFragment() {
    override val layoutId = R.layout.fragment_ipo_cost_calculator

    companion object {
        fun newInstance(): IPOCostCalculatorFragment {
            return IPOCostCalculatorFragment()
        }
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun fragmentVisible() {
        super.fragmentVisible()
        (activity as ToolsChildActivity).setToolbarTitle(getString(R.string.ipo_cost_calculator))
    }
}
