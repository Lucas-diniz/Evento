package com.lucas.diniz.extension.function

import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.util.*

fun Long.toDataFormatted(pattern: String): String =
    try {
        val format = SimpleDateFormat(pattern, Locale.US)
        val data = Date(Timestamp(this).time)
        format.format(data)
    } catch (e: Exception) {
        ""
    }
