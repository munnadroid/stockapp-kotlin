package com.awecode.stockapp.util

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by munnadroid on 5/24/17.
 */

fun ViewGroup.inflate(layoutId: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutId, this, attachToRoot)
}
