package com.example.car_project

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Car(
    val name: String,
    val description : String,
    val photo : Int,
    val specification : String
) : Parcelable
