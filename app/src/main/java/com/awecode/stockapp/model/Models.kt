package com.awecode.stockapp.model

import paperparcel.PaperParcel
import paperparcel.PaperParcelable

/**
 * Created by munnadroid on 5/26/17.
 */
@PaperParcel
data class Indice(val name: String = "", val finalPrice: Double, val increaseInPoint: Double,
                  val decreaseInPoint: Double, val increaseInPercent: Double, val lastUpdateDate: String = "",
                  val type: String = "") : PaperParcelable {
    companion object {
        @JvmField val CREATOR = PaperParcelIndice.CREATOR
    }
}

data class ShareItem(val label: String, val amount: Double)
