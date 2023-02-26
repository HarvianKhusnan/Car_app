package com.example.car_project

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


data class Car(
    var name: String,
    var description : String,
    var photo : Int,
    val specification : String
)
