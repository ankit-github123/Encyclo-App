package com.example.planeto

import android.os.Parcel
import android.os.Parcelable

data class CollegeData(
    val id: Long?,
    val title:String?,
    val identity:String?,
    val designation:String?,
    val type:String?,
    val overview:String?,
    val image: Int?=null

):Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readValue(Int::class.java.classLoader) as? Long,
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(id)
        parcel.writeString(title)
        parcel.writeString(identity)
        parcel.writeString(designation)
        parcel.writeString(type)
        parcel.writeString(overview)
        parcel.writeValue(image)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<CollegeData> {
        override fun createFromParcel(parcel: Parcel): CollegeData {
            return CollegeData(parcel)
        }

        override fun newArray(size: Int): Array<CollegeData?> {
            return arrayOfNulls(size)
        }
    }

}