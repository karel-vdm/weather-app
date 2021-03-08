package com.karel.weather_app.domain.model

data class ForecastEntity(
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
)