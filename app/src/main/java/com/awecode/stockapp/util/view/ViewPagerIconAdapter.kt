package com.awecode.stockapp.util.view

/**
 * Created by munnadroid on 5/23/17.
 */

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import android.support.v4.content.ContextCompat
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ImageSpan
import java.util.*


class ViewPagerIconAdapter(fragmentManager: FragmentManager, var ctx: Context) : FragmentStatePagerAdapter(fragmentManager) {

    private val fragments = ArrayList<Fragment>()
    private val titles = ArrayList<String>()
    private val images = ArrayList<Int>()

    fun addFragment(fragment: Fragment, title: String, image: Int) {
        fragments.add(fragment)
        titles.add(title)
        images.add(image)
    }

    override fun getItem(position: Int): Fragment {
        return fragments[position]
    }

    override fun getCount(): Int {
        return fragments.size
    }

    override fun getPageTitle(position: Int): CharSequence {


        val image = ContextCompat.getDrawable(ctx, images[position])
        image.setBounds(0, 0, image.intrinsicWidth, image.intrinsicHeight)
        val sb = SpannableString(" " + titles[position])
        val imageSpan = ImageSpan(image)
        sb.setSpan(imageSpan, 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        return sb

        return titles[position]
    }
}