package com.awecode.stockapp

import android.os.Bundle
import com.awecode.stockapp.view.base.BaseActivity
import com.awecode.stockapp.view.home.market.MarketFragment
import kotlinx.android.synthetic.main.toolbar_home.*


class MainActivity : BaseActivity() {
    override val layoutId: Int = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSupportActionBar(toolbar)
        changeFragment(MarketFragment.newInstance(), true, false)
    }
}
