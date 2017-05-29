package com.awecode.stockapp.view.tools

import android.os.Bundle
import android.view.View
import com.awecode.stockapp.R
import com.awecode.stockapp.view.base.BaseFragment


class IPOAllotmentCalculatorFragment : BaseFragment() {
    override val layoutId = R.layout.fragment_ipo_allotment_calculator

    companion object {
        fun newInstance(): IPOAllotmentCalculatorFragment {
            return IPOAllotmentCalculatorFragment()
        }
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun fragmentVisible() {
        super.fragmentVisible()
        (activity as ToolsChildActivity).setToolbarTitle(getString(R.string.ipo_allotment_calculator))
    }
}
