package com.karel.weather_app.presentation.forecast

import android.app.Activity
import androidx.lifecycle.*
import com.karel.weather_app.data.api.WeatherService
import com.karel.weather_app.data.repository.WeatherRepositoryImpl
import com.karel.weather_app.domain.usecase.UseCaseGetWeatherByLocation
import com.karel.weather_app.presentation.permission.LocationServicesManager
import com.karel.weather_app.presentation.permission.PermissionsManager
import com.karel.weather_app.presentation.widget.forecast.ForecastViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val useCaseGetWeatherByLocation = UseCaseGetWeatherByLocation(
        WeatherRepositoryImpl(
            WeatherService.create()
        )
    )

    private var _forecast = MutableLiveData<ForecastViewModel>()
    val forecast: LiveData<ForecastViewModel> get() = _forecast

    private var _isForeCastViewVisible = MutableLiveData<Boolean>()
    val isForeCastViewVisible: LiveData<Boolean> get() = _isForeCastViewVisible

    private var _error = MutableLiveData<String>()
    val error: LiveData<String> get() = _error

    private var _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> get() = _loading

    private var _hasPermissions = MutableLiveData<Boolean>()
    val hasPermissions: LiveData<Boolean> get() = _hasPermissions

    private var _locationEnabled = MutableLiveData<Boolean>()
    val isLocationEnabled: LiveData<Boolean> get() = _locationEnabled

    private var wasPermissionDenied = false

    fun checkPermissionsAndGetWeather(activity: Activity) {
        _isForeCastViewVisible.value = false

        if (wasPermissionDenied) {
            return
        }

        if (PermissionsManager.hasLocationPermission(
                activity
            )
        ) {
            _hasPermissions.value = true
            getLastKnownLocation(activity)
        } else {
            _hasPermissions.value = false
            PermissionsManager.requestLocationPermission(
                activity
            )
        }
    }

    fun updatePermissions(activity: Activity, requestCode: Int, grantResults: IntArray) {
        if (wasPermissionDenied) {
            return
        }

        if (PermissionsManager.wasPermissionGranted(
                requestCode,
                grantResults
            )
        ) {
            _hasPermissions.value = true
            getLastKnownLocation(activity)
        } else {
            wasPermissionDenied = true
            _hasPermissions.value = false
        }
    }

    private fun getWeatherByLocation(lat: String, lng: String) {
        viewModelScope.launch {
            useCaseGetWeatherByLocation.getWeatherByLocation(lat, lng)
                .onStart {
                    _error.value = ""
                    _loading.value = true
                }
                .catch { exception ->
                    _error.value = exception.message ?: "error"
                    _loading.value = false
                }
                .collect { result ->
                    _forecast.value = TransformerForecastViewModel.transform(result)
                    _loading.value = false
                }
        }
    }

    private fun getLastKnownLocation(activity: Activity) {
        if (isLocationEnabled(activity)) {
            _locationEnabled.value = true
            LocationServicesManager.getLastKnownLocation(
                activity,
                { location ->
                    getWeatherByLocation(
                        lat = location.latitude.toString(),
                        lng = location.longitude.toString()
                    )
                },
                { error ->
                    _error.value = error
                })
        } else {
            _locationEnabled.value = false
        }
    }

    private fun isLocationEnabled(activity: Activity): Boolean {
        return LocationServicesManager.isLocationEnabled(
            activity
        )
    }

}