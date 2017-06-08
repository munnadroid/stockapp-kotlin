package com.awecode.stockapp.util

import android.support.v7.widget.Toolbar

/**
 * Created by munnadroid on 5/23/17.
 */

class Util {
    companion object {
        fun parseInt(str: String): Int? {
            try {
                return Integer.parseInt(str)
            } catch(e: Exception) {
                e.printStackTrace()
                return null
            }
        }

        fun parseDouble(str: String): Double? {
            try {
                return str.toDoubleOrNull()
            } catch(e: Exception) {
                e.printStackTrace()
                return null
            }
        }

        fun setToolbarTitle(toolbar: Toolbar, title: String) {
            toolbar.title = title
        }
    }
}


