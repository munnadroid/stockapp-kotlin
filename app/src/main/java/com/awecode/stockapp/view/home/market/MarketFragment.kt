package com.awecode.stockapp.view.home.market

import android.os.Bundle
import android.support.v4.view.ViewPager
import com.awecode.stockapp.R
import com.awecode.stockapp.util.view.ViewPagerAdapter
import com.awecode.stockapp.view.base.BaseFragment
import com.awecode.stockapp.view.home.market.indices.IndicesFragment
import kotlinx.android.synthetic.main.fragment_market.*

/**
 * Created by munnadroid on 5/23/17.
 */
class MarketFragment : BaseFragment() {

    companion object {
        fun newInstance(): MarketFragment {
            return MarketFragment()
        }
    }

    override val layoutId: Int = R.layout.fragment_market


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


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setupViewPager()
    }


    /**
     * setup market viewpager
     */
    private fun setupViewPager() {
        val pagerAdapter = ViewPagerAdapter(childFragmentManager)

        pagerAdapter.addFragment(IndicesFragment.newInstance(), "Indices")
        pagerAdapter.addFragment(IndicesFragment.newInstance(), "Stocks")
        pagerAdapter.addFragment(IndicesFragment.newInstance(), "Commodities")
        pagerAdapter.addFragment(IndicesFragment.newInstance(), "Forex")

        viewPager.adapter = pagerAdapter
        viewPager.addOnPageChangeListener(onPageChangeListener)
        tabLayout.setupWithViewPager(viewPager)

    }

}