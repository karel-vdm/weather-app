package com.karel.weather_app.presentation.forecast

import com.karel.weather_app.domain.model.ForecastEntity
import com.karel.weather_app.presentation.widget.forecast.ForecastViewModel

object TransformerForecastViewModel {

    fun transform(forecast: ForecastEntity) =
        ForecastViewModel(
            currentLocation = forecast.currentLocation,
            currentTemperature = forecast.currentTemperature,
            currentWeatherImageUrl = forecast.currentWeatherImageUrl,
            date = forecast.date,
            currentWeatherDescription = forecast.currentWeatherDescription,
            minTemperature = forecast.minTemperature,
            maxTemperature = forecast.maxTemperature,
            windSpeed = forecast.windSpeed,
            humidity = forecast.humidity,
            visibility = forecast.visibility,
            airPressure = forecast.airPressure
        )

}