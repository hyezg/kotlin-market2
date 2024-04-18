package com.example.applemarket
import kotlinx.android.parcel.Parcelize
import android.os.Parcelable

@Parcelize
data class Item (
    val image: Int,
    val title: String,
    val introduce: String,
    val seller: String,
    val price: Int,
    val place: String,
    val good: Int,
    val chat: Int,
    val viewtype: Int
) : Parcelable