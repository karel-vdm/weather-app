package com.karel.weather_app.presentation.forecast

import com.karel.weather_app.presentation.widget.forecast.ForecastViewModel

interface IMainActivityView {

    fun renderForecastView(value: ForecastViewModel)

    fun hideForecastView()

    fun renderErrorView(errorMessage: String)

    fun hideErrorView()

    fun hideLoadingView()

    fun renderLoadingView()

    fun renderTurnOnLocationView()

    fun renderAllowPermissionsView()

    fun hideAllowPermissionsView()

    fun hideTurnOnLocationView()
}
