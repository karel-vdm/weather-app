package com.karel.weather_app.presentation.forecast

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import com.karel.weather_app.databinding.ActivityMainBinding
import com.karel.weather_app.presentation.permission.PermissionsManager
import com.karel.weather_app.presentation.widget.forecast.ForecastViewModel

class MainActivity : AppCompatActivity(),
    IMainActivityView {

    private lateinit var binding: ActivityMainBinding

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        observeViewModel()
    }

    override fun onResume() {
        super.onResume()
        viewModel.checkPermissionsAndGetWeather(this)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        viewModel.updatePermissions(this, requestCode, grantResults)
    }

    override fun renderForecastView(value: ForecastViewModel) {
        binding.forecastView.isVisible = true
        binding.forecastView.onBindView(value)
        binding.forecastView.setOnRefreshClickListener {
            viewModel.checkPermissionsAndGetWeather(this)
        }
    }

    override fun hideForecastView() {
        binding.forecastView.isVisible = false
    }

    override fun renderErrorView(errorMessage: String) {
        binding.errorView.isVisible = true
        binding.errorView.setOnTryAgainClickListener {
            viewModel.checkPermissionsAndGetWeather(this)
        }
    }

    override fun hideErrorView() {
        binding.errorView.isVisible = false
    }

    override fun renderLoadingView() {
        binding.forecastLoadingView.isVisible = true
        binding.forecastLoadingView.startShimmer()
    }

    override fun hideLoadingView() {
        binding.forecastLoadingView.isVisible = false
    }

    override fun renderAllowPermissionsView() {
        binding.allowPermissionsView.isVisible = true
        binding.allowPermissionsView.onAllowPermissionsClickListener = {
            PermissionsManager.requestLocationPermission(
                this
            )
        }
    }

    override fun hideAllowPermissionsView() {
        binding.allowPermissionsView.isVisible = false
    }

    override fun renderTurnOnLocationView() {
        binding.turnOnLocationView.isVisible = true
        binding.turnOnLocationView.onTurnOnLocationClickListener = {
            val intent = Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS)
            startActivity(intent)
        }
    }

    override fun hideTurnOnLocationView() {
        binding.turnOnLocationView.isVisible = false
    }

    private fun observeViewModel() {
        viewModel.forecast.observe(this, Observer { value ->
            renderForecastView(value)
        })

        viewModel.isForeCastViewVisible.observe(this, Observer { value ->
            if (!value) {
                hideForecastView()
            }
        })

        viewModel.error.observe(this, Observer { value ->
            if (value.isNotEmpty()) {
                renderErrorView(value)
            } else {
                hideErrorView()
            }
        })

        viewModel.loading.observe(this, Observer { value ->
            if (value) {
                renderLoadingView()
            } else {
                hideLoadingView()
            }
        })

        viewModel.hasPermissions.observe(this, Observer { value ->
            if (!value) {
                renderAllowPermissionsView()
            } else {
                hideAllowPermissionsView()
            }
        })

        viewModel.isLocationEnabled.observe(this, Observer { value ->
            if (!value) {
                renderTurnOnLocationView()
            } else {
                hideTurnOnLocationView()
            }
        })
    }
}