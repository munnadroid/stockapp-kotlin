package com.awecode.stockapp.view.news

import com.awecode.stockapp.R
import com.awecode.stockapp.view.base.BaseFragment

/**
 * Created by munnadroid on 5/23/17.
 */
class NewsFragment : BaseFragment() {


    companion object {

        fun newInstance(): NewsFragment {
            return NewsFragment()
        }
    }

    override val layoutId: Int = R.layout.fragment_news
}