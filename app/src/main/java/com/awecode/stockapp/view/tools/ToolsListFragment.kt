package com.awecode.stockapp.view.tools

import android.os.Bundle
import android.view.View
import com.awecode.stockapp.MainActivity
import com.awecode.stockapp.R
import com.awecode.stockapp.util.extensions.launchActivity
import com.awecode.stockapp.view.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_tools_list.*

/**
 * Created by munnadroid on 5/29/17.
 */
class ToolsListFragment : BaseFragment() {
    override val layoutId = R.layout.fragment_tools_list

    companion object {
        fun newInstance(): ToolsListFragment {
            return ToolsListFragment()
        }
    }


    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        shareCalcBtn.setOnClickListener({
            launchToolChildView(ViewType.SHARE_VIEW)
        })

        ipoCostCalcBtn.setOnClickListener({
            launchToolChildView(ViewType.IPOCOST_CALC)
        })

        ipoAllotmentBtn.setOnClickListener({
            launchToolChildView(ViewType.IPOALLOTMENT_CALC)
        })
    }

    /**
     * open tool child activity which handle fragment open
     */
    private fun launchToolChildView(viewType: ViewType) {
        launchActivity<ToolsChildActivity> {
            putExtra(ToolsChildActivity.INTENT_VIEW_TYPE, viewType)
        }
    }

    override fun fragmentVisible() {
        super.fragmentVisible()
        (activity as MainActivity).setToolbarTitle(getString(R.string.app_name))
    }

    enum class ViewType {
        SHARE_VIEW,
        IPOCOST_CALC,
        IPOALLOTMENT_CALC
    }
}