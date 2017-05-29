package com.awecode.stockapp.view.tools

import android.os.Bundle
import android.view.View
import com.awecode.stockapp.R
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
        })

        ipoCostCalcBtn.setOnClickListener({

        })

        ipoAllotmentBtn.setOnClickListener({

        })
    }

}