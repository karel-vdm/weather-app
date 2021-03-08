package com.karel.weather_app.presentation.permission

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.location.Location
import android.location.LocationManager
import com.google.android.gms.location.LocationServices

object LocationServicesManager {

    @SuppressLint("MissingPermission")
    fun getLastKnownLocation(
        activity: Activity,
        onCompleteListener: (Location) -> Unit,
        onErrorListener: (String) -> Unit
    ) {
        val locationService = LocationServices.getFusedLocationProviderClient(activity)
        locationService.lastLocation
            .addOnSuccessListener { location: Location? ->
                if (location != null) {
                    onCompleteListener.invoke(location)
                }
            }.addOnFailureListener { exception ->
                onErrorListener.invoke(exception.message ?: "")
            }
    }

    fun isLocationEnabled(context: Context): Boolean {
        val locationService = context.getSystemService(Context.LOCATION_SERVICE)
        if (locationService is LocationManager) {
            return locationService.isProviderEnabled(LocationManager.GPS_PROVIDER)
        }
        return false
    }

}