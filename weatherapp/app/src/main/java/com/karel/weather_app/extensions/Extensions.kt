package com.karel.weather.extensions

import java.math.RoundingMode
import java.text.DecimalFormat

fun Double.round(format: String): String {
    return try {
        val decimalFormat = DecimalFormat(format)
        decimalFormat.roundingMode = RoundingMode.CEILING
        return decimalFormat.format(this).toString()
    } catch (exception: ArithmeticException) {
        "0"
    }
}
