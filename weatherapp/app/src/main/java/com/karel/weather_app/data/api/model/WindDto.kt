package com.karel.weather_app.data.api.model

import com.google.gson.annotations.SerializedName

data class WindDto(

    @SerializedName("speed")
    val speed: Double = 0.0,

    @SerializedName("deg")
    val deg: Double = 0.0
)