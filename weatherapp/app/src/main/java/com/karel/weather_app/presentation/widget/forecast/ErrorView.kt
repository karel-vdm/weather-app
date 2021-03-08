package com.karel.weather_app.presentation.widget.forecast

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.karel.weather_app.databinding.LayoutErrorBinding

class ErrorView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    private var binding: LayoutErrorBinding =
        LayoutErrorBinding.inflate(LayoutInflater.from(context), this, true)

    fun setOnTryAgainClickListener(onClickListener: () -> Unit) {
        binding.tryAgainButton.setOnClickListener {
            onClickListener.invoke()
        }
    }

}

