package com.karel.weather_app.data.api.model

import com.google.gson.annotations.SerializedName

data class ForecastDto(

    @SerializedName("main")
    val main: MainDto = MainDto(),

    @SerializedName("weather")
    val weather: List<WeatherDto> = emptyList(),

    @SerializedName("wind")
    val wind: WindDto = WindDto(),

    @SerializedName("sys")
    val sys: SysDto = SysDto(),

    @SerializedName("dt")
    val dt: Long = 0,

    @SerializedName("visibility")
    val visibility: Double = 0.0,

    @SerializedName("name")
    val name: String = String()
)