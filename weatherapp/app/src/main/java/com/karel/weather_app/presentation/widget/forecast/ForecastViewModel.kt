package com.karel.weather_app.presentation.widget.forecast

import android.annotation.SuppressLint
import com.karel.weather.extensions.round
import java.text.SimpleDateFormat
import java.util.*

data class ForecastViewModel(
    val currentLocation: String = String(),
    val currentWeatherDescription: String = String(),
    val currentWeatherImageUrl: String = String(),
    val date: Long = 0,
    val currentTemperature: Double = 0.0,
    val minTemperature: Double = 0.0,
    val maxTemperature: Double = 0.0,
    val windSpeed: Double = 0.0,
    val airPressure: Double = 0.0,
    val humidity: Double = 0.0,
    val visibility: Double = 0.0
) {

    val currentTemperatureDisplay: String
        get() {
            return "${currentTemperature.round("#")}°C"
        }

    val dateDisplay: String
        get() {
            return "Date: ${formatUnixTimestampToDate(date)}"
        }

    val windSpeedDisplay: String
        get() {
            return "Wind speed: ${windSpeed.round("#,##")} km/h"
        }

    val airPressureDisplay: String
        get() {
            return "Air pressure: ${airPressure.round("#")} mbar"
        }

    val humidityDisplay: String
        get() {
            return "Humidity: ${humidity.round("#,##")}%"
        }

    val visibilityDisplay: String
        get() {
            return "Visibility: ${visibility / 1000} km"
        }

    val minMaxTemperatureDisplay: String
        get() {
            return "${minTemperature.round("#")}°C / ${maxTemperature.round("#")}°C"
        }

    @SuppressLint("SimpleDateFormat")
    private fun formatUnixTimestampToDate(unixTimeStamp: Long): String {
        val dateFormat = SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss")
        val date = Date(unixTimeStamp * 1000)
        return dateFormat.format(date)
    }
}