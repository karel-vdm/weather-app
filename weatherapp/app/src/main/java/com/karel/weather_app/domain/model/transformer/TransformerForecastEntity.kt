package com.karel.weather_app.domain.model.transformer

import com.karel.weather_app.data.api.model.ForecastDto
import com.karel.weather_app.domain.model.ForecastEntity

object TransformerForecastEntity {

    fun transform(forecast: ForecastDto) = ForecastEntity(
        currentLocation = forecast.name,
        currentWeatherDescription = getDescriptionOrDefault(forecast),
        currentWeatherImageUrl = "https://openweathermap.org/img/w/${getDescriptionIconOrDefault(forecast)}.png",
        date = forecast.dt,
        currentTemperature = forecast.main.temp,
        minTemperature = forecast.main.temp_min,
        maxTemperature = forecast.main.temp_max,
        windSpeed = forecast.wind.speed,
        humidity = forecast.main.humidity,
        airPressure = forecast.main.pressure,
        visibility = forecast.visibility
    )

    private fun getDescriptionOrDefault(forecast: ForecastDto): String {
        return forecast.weather.firstOrNull()?.description ?: "-"
    }

    private fun getDescriptionIconOrDefault(forecast: ForecastDto): String {
        return forecast.weather.firstOrNull()?.icon ?: ""
    }
}