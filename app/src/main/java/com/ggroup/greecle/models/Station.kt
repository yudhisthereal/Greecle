package com.ggroup.greecle.models

import android.location.Location

data class Station(
    val stationName: String?,
    val stationCoordinate: Location,
//    val stationLocation: GreecleLocation,
    val stationAvailability: Boolean
)
