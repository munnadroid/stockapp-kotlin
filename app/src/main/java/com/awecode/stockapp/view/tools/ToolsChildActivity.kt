package com.awecode.stockapp.view.tools

import android.os.Bundle
import com.awecode.stockapp.R
import com.awecode.stockapp.util.Util
import com.awecode.stockapp.util.extensions.changeDefaultNavIconColor
import com.awecode.stockapp.util.extensions.colorRes
import com.awecode.stockapp.view.base.BaseActivity
import kotlinx.android.synthetic.main.toolbar_home.*

/**
 * Created by munnadroid on 5/29/17.
 */
class ToolsChildActivity : BaseActivity() {
    override val layoutId: Int = R.layout.activity_tools_child

    companion object {
        val INTENT_VIEW_TYPE = "intent_view_type"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupToolbar()

        val viewType = intent.getSerializableExtra(INTENT_VIEW_TYPE) as ToolsListFragment.ViewType
        requireNotNull(viewType) { finish() }

        switchView(viewType)

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    fun setupToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.changeDefaultNavIconColor(applicationContext, colorRes(R.color.white))
    }

    open fun setToolbarTitle(title: String) {
        Util.setToolbarTitle(toolbar, title)
    }

    /**
     * change fragment by view type enum
     */
    fun switchView(viewType: ToolsListFragment.ViewType) {
        when (viewType) {
            ToolsListFragment.ViewType.SHARE_VIEW -> changeFragment(ShareCalculatorFragment.newInstance(), addToBackStack = false)
            ToolsListFragment.ViewType.IPOCOST_CALC -> changeFragment(IPOCostCalculatorFragment.newInstance(), addToBackStack = false)
            ToolsListFragment.ViewType.IPOALLOTMENT_CALC -> changeFragment(IPOAllotmentCalculatorFragment.newInstance(), addToBackStack = false)
            else -> finish()

        }
    }
}