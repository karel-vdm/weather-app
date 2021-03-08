package com.karel.weather_app.data.api.model

import com.google.gson.annotations.SerializedName

data class WeatherDto(

    @SerializedName("main")
    val main: String = String(),

    @SerializedName("description")
    val description: String = String(),

    @SerializedName("icon")
    val icon: String = String()
)