package com.awecode.stockapp

import android.os.Bundle
import android.support.v4.view.ViewPager
import com.awecode.stockapp.util.changeIconColor
import com.awecode.stockapp.util.view.ViewPagerAdapter
import com.awecode.stockapp.view.base.BaseActivity
import com.awecode.stockapp.view.market.MarketFragment
import com.awecode.stockapp.view.news.NewsFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar_home.*


class MainActivity : BaseActivity() {
    override val layoutId: Int = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSupportActionBar(toolbar)

        setupViewPager()
    }

    /**
     * setup market viewpager
     */
    private fun setupViewPager() {
        val pagerAdapter = ViewPagerAdapter(supportFragmentManager)

        pagerAdapter.addFragment(MarketFragment.newInstance(), "Market")
        pagerAdapter.addFragment(NewsFragment.newInstance(), "News")
        pagerAdapter.addFragment(NewsFragment.newInstance(), "Calendar")
        pagerAdapter.addFragment(NewsFragment.newInstance(), "Portfolio")


        viewPager.adapter = pagerAdapter
        viewPager.addOnPageChangeListener(onPageChangeListener)
        slidingTabs.setupWithViewPager(viewPager)

        //set tab icons
        setupTabIcons()
    }

    /**
     * change tab icon color in selected/unselected state
     */
    private fun setupTabIcons() {
        for (i in 0..tabIcons.size)
            slidingTabs.getTabAt(i)?.setIcon(tabIcons[i])

        slidingTabs.changeIconColor(theme, slidingTabs, R.color.tablayout_icon_color)

    }

    /**
     * array list of tab icons
     */
    private val tabIcons: IntArray = intArrayOf(R.drawable.ic_graphic_eq_white_24dp,
            R.drawable.ic_graphic_eq_white_24dp,
            R.drawable.ic_graphic_eq_white_24dp,
            R.drawable.ic_graphic_eq_white_24dp)
    /**
     * listen viewpager change
     */
    private val onPageChangeListener = object : ViewPager.OnPageChangeListener {
        override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
        }

        override fun onPageSelected(position: Int) {

        }

        override fun onPageScrollStateChanged(state: Int) {
        }
    }


}


