package com.awecode.stockapp.view.tools

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import com.awecode.stockapp.R
import com.awecode.stockapp.view.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_share_calculator.*


class ShareCalculatorFragment : BaseFragment() {
    override val layoutId = R.layout.fragment_share_calculator

    companion object {
        fun newInstance(): ShareCalculatorFragment {
            return ShareCalculatorFragment()
        }
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupTypeSpinner()
    }

    private fun setupTypeSpinner() {
        val txnTypeList = listOf("Buy", "Sell")
        val adapter = ArrayAdapter(activity, R.layout.row_spn, txnTypeList)
        adapter.setDropDownViewResource(R.layout.row_spn_dropdown)
        txnTypeSpinnner.adapter = adapter
    }

    override fun fragmentVisible() {
        super.fragmentVisible()
        (activity as ToolsChildActivity).setToolbarTitle(getString(R.string.share_calculator))
    }
}
