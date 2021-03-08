package com.karel.weather_app.presentation.widget.permission

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import com.google.android.material.button.MaterialButton
import com.karel.weather_app.R

class AllowPermissionsView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    private var turnOnLocationButton: MaterialButton? = null

    var onAllowPermissionsClickListener: () -> Unit = {}

    init {
        View.inflate(context, R.layout.layout_allow_permissions, this)
        turnOnLocationButton = findViewById(R.id.turn_on_location_button)
        turnOnLocationButton?.setOnClickListener {
            onAllowPermissionsClickListener.invoke()
        }
    }

}