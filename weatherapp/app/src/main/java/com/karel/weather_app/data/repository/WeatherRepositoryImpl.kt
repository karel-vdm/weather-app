package com.karel.weather_app.data.repository

import com.karel.weather_app.data.api.WeatherService
import com.karel.weather_app.data.api.model.ForecastDto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

private const val API_KEY = "9ef009fed644e5c1e00cb13fa8b0c5e0"
private const val UNITS = "metric"

class WeatherRepositoryImpl(
    private val weatherService: WeatherService
) : WeatherRepository {

    override fun getWeatherByLocation(lat: String, lng: String): Flow<ForecastDto> = flow {
        val forecast = weatherService.getWeatherByLocation(lat, lng, API_KEY, UNITS)
        emit(forecast)
    }.flowOn(Dispatchers.IO)

}