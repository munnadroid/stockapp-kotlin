package com.awecode.stockapp.model

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by munnadroid on 5/26/17.
 */
data class Indice(val name: String = "", val finalPrice: Double, val increaseInPoint: Double,
                  val decreaseInPoint: Double, val increaseInPercent: Double, val lastUpdateDate: String = "",
                  val type: String = "") : Parcelable {
    companion object {
        @JvmField val CREATOR: Parcelable.Creator<Indice> = object : Parcelable.Creator<Indice> {
            override fun createFromParcel(source: Parcel): Indice = Indice(source)
            override fun newArray(size: Int): Array<Indice?> = arrayOfNulls(size)
        }
    }

    constructor(source: Parcel) : this(
    source.readString(),
    source.readDouble(),
    source.readDouble(),
    source.readDouble(),
    source.readDouble(),
    source.readString(),
    source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(name)
        dest.writeDouble(finalPrice)
        dest.writeDouble(increaseInPoint)
        dest.writeDouble(decreaseInPoint)
        dest.writeDouble(increaseInPercent)
        dest.writeString(lastUpdateDate)
        dest.writeString(type)
    }
}