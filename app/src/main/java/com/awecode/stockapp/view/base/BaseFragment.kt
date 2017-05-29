package com.awecode.stockapp.view.base


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.awecode.stockapp.util.extensions.inflate

/**
 * Created by munnadroid on 5/23/17.
 */
abstract class BaseFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return container?.inflate(layoutId)
    }

    abstract val layoutId: Int


}
