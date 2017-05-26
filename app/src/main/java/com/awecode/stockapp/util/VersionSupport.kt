package com.awecode.stockapp.util

/**
 * Created by munnadroid on 5/26/17.
 */
import android.os.Build

fun supportsKitKat(code: () -> Unit) {
    supportsVersion(code, 19)
}

fun supportsLollipop(code: () -> Unit) {
    supportsVersion(code, 21)
}

private fun supportsVersion(code: () -> Unit, sdk: Int) {
    if (Build.VERSION.SDK_INT >= sdk) {
        code.invoke()
    }
}