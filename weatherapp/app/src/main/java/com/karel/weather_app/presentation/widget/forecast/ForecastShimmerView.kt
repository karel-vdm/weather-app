package com.karel.weather_app.presentation.widget.forecast

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import com.facebook.shimmer.ShimmerFrameLayout
import com.karel.weather_app.databinding.LayoutForecastShimmerBinding

class ForecastShimmerView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ShimmerFrameLayout(context, attrs, defStyleAttr) {

    init {
        LayoutForecastShimmerBinding.inflate(LayoutInflater.from(context), this, true)
    }

}

