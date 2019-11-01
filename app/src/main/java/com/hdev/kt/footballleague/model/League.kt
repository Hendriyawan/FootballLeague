package com.hdev.kt.footballleague.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class League(val logo: String, val name: String, val description: String) : Parcelable