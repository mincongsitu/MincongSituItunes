package com.example.mincongsituitunes.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ItuneResponse(
    val results: List<Itune>
):Parcelable

@Parcelize
data class Itune(
    val artistName: String,
    val collectionName: String,
    val artworkUrl60: String,
    val trackPrice: Double,
    val currency: String
):Parcelable{
   fun getPrice() = "$trackPrice $currency"
}

