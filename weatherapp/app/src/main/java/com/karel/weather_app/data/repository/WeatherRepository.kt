package com.karel.weather_app.data.repository

import com.karel.weather_app.data.api.model.ForecastDto
import kotlinx.coroutines.flow.Flow

interface WeatherRepository {

    fun getWeatherByLocation(lat: String, lng: String): Flow<ForecastDto>

}