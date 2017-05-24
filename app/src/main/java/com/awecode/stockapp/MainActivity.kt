package com.awecode.stockapp

import android.os.Bundle
import android.support.v4.graphics.drawable.DrawableCompat
import com.awecode.stockapp.view.base.BaseActivity
import com.awecode.stockapp.view.home.market.MarketFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar_home.*
import org.jetbrains.anko.toast


class MainActivity : BaseActivity() {
    override val layoutId: Int = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSupportActionBar(toolbar)
        changeFragment(MarketFragment.newInstance(), true, false)
        marketsButton.setOnClickListener({
           toast("btn clicked")
        })

    }


}

