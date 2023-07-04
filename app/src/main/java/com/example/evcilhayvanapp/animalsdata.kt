package com.example.evcilhayvanapp

import android.os.Parcel
import android.os.Parcelable


data class animalsdata(val title: String?, val logo: Int,val bilgiler: String?):Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readInt(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeInt(logo)
        parcel.writeString(bilgiler)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<animalsdata> {
        override fun createFromParcel(parcel: Parcel): animalsdata {
            return animalsdata(parcel)
        }

        override fun newArray(size: Int): Array<animalsdata?> {
            return arrayOfNulls(size)
        }
    }

}