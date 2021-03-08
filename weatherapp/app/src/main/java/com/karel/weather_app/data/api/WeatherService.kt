package com.karel.weather_app.data.api

import com.karel.weather_app.data.api.model.ForecastDto
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {

    @GET("weather")
    suspend fun getWeatherByLocation(
        @Query("lat") lat: String,
        @Query("lon") lng: String,
        @Query("appid") appid: String,
        @Query("units") units: String
    ): ForecastDto

    companion object {
        private val BASE_URL = "https://api.openweathermap.org/data/2.5/"

        private var _retrofit: Retrofit? = null
        private val retrofit: Retrofit
            get() {
                if (_retrofit == null) {
                    val logger = HttpLoggingInterceptor()
                    logger.level = HttpLoggingInterceptor.Level.BASIC

                    val client = OkHttpClient.Builder()
                        .addInterceptor(logger)
                        .build()

                    _retrofit = Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .client(client)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
                }
                return _retrofit!!
            }

        fun create(): WeatherService = retrofit.create(WeatherService::class.java)
    }

}

