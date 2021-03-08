package com.karel.weather_app.presentation.permission

import android.Manifest
import android.app.Activity
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat

private const val PERMISSION_RESULT_CODE = 10

object PermissionsManager {

    fun requestLocationPermission(activity: Activity) {
        val permissions = arrayOf(
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.ACCESS_FINE_LOCATION
        )
        ActivityCompat.requestPermissions(activity, permissions,
            PERMISSION_RESULT_CODE
        )
    }

    fun hasLocationPermission(activity: Activity): Boolean {
        return ActivityCompat.checkSelfPermission(
            activity,
            Manifest.permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
            activity,
            Manifest.permission.ACCESS_COARSE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED
    }

    fun wasPermissionGranted(requestCode: Int, grantResults: IntArray): Boolean {
        if (requestCode == PERMISSION_RESULT_CODE
            && grantResults.firstOrNull() == PackageManager.PERMISSION_GRANTED
        ) {
            return true
        }
        return false
    }

}