package com.karel.weather_app.data.api.model

import com.google.gson.annotations.SerializedName

data class MainDto(

    @SerializedName("temp")
    val temp: Double = 0.0,

    @SerializedName("temp_min")
    val temp_min: Double = 0.0,

    @SerializedName("temp_max")
    val temp_max: Double = 0.0,

    @SerializedName("humidity")
    val humidity: Double = 0.0,

    @SerializedName("pressure")
    val pressure: Double = 0.0
)