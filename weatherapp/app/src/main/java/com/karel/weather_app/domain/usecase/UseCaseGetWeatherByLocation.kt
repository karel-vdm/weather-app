package com.karel.weather_app.domain.usecase

import com.karel.weather_app.data.repository.WeatherRepository
import com.karel.weather_app.domain.model.ForecastEntity
import com.karel.weather_app.domain.model.transformer.TransformerForecastEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class UseCaseGetWeatherByLocation(
    private val weatherRepository: WeatherRepository
) {

    fun getWeatherByLocation(lat: String, lng: String): Flow<ForecastEntity> =
        weatherRepository.getWeatherByLocation(lat, lng).map { result ->
            TransformerForecastEntity.transform(result)
        }

}