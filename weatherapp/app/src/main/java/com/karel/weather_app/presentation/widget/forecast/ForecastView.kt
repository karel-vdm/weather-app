package com.karel.weather_app.presentation.widget.forecast

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.bumptech.glide.Glide
import com.karel.weather_app.databinding.LayoutForecastBinding

class ForecastView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    private var binding: LayoutForecastBinding =
        LayoutForecastBinding.inflate(LayoutInflater.from(context), this, true)

    fun onBindView(viewModel: ForecastViewModel) {
        binding.currentTemperature.text = viewModel.currentTemperatureDisplay
        binding.location.text = viewModel.currentLocation
        binding.currentConditions.text = viewModel.currentWeatherDescription
        binding.date.text = viewModel.dateDisplay
        binding.windSpeed.text = viewModel.windSpeedDisplay
        binding.airPressure.text = viewModel.airPressureDisplay
        binding.humidity.text = viewModel.humidityDisplay
        binding.visibility.text = viewModel.visibilityDisplay
        binding.minMaxTemperature.text = viewModel.minMaxTemperatureDisplay

        Glide.with(context)
            .load(viewModel.currentWeatherImageUrl)
            .centerCrop()
            .into(binding.currentConditionsImage)
    }

    fun setOnRefreshClickListener(onClickListener: () -> Unit) {
        binding.refreshButton.setOnClickListener {
            onClickListener.invoke()
        }
    }
}

