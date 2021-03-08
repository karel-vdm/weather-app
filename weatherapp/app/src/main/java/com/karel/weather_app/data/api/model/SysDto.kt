package com.karel.weather_app.data.api.model

import com.google.gson.annotations.SerializedName

data class SysDto(

    @SerializedName("sunrise")
    val sunrise: String = String(),

    @SerializedName("sunset")
    val sunset: String = String()
)