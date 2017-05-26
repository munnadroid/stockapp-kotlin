package com.awecode.stockapp.view.model

/**
 * Created by munnadroid on 5/26/17.
 */
data class Indices(val name: String = "", val finalPrice: Double, val increaseInPoint: Double,
                   val decreaseInPoint: Double, val increaseInPercent: Double, val lastUpdateDate: String = "",
                   val type: String = "")