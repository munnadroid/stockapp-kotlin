package com.awecode.stockapp.view.home

import android.support.v4.app.Fragment
import com.awecode.stockapp.R
import com.awecode.stockapp.view.base.BaseFragment

/**
 * Created by munnadroid on 5/23/17.
 */
class HomeFragment : BaseFragment() {
    companion object {
        fun newInstance(): HomeFragment {
            return HomeFragment()
        }
    }

    override fun getLayout() = R.layout.fragment_home
}


