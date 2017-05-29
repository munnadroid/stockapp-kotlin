package com.awecode.stockapp.view.tools

import android.os.Bundle
import android.view.View
import com.awecode.stockapp.MainActivity
import com.awecode.stockapp.R
import com.awecode.stockapp.view.base.BaseFragment


class ShareCalculatorFragment : BaseFragment() {
    override val layoutId = R.layout.fragment_share_calculator

    companion object {
        fun newInstance(): ShareCalculatorFragment {
            return ShareCalculatorFragment()
        }
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun fragmentVisible() {
        super.fragmentVisible()
        (activity as ToolsChildActivity).setToolbarTitle(getString(R.string.share_calculator))
    }
}
