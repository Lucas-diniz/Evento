package com.lucas.diniz.events.dto

import java.util.*

data class Events(
    val people: String = "",
    val date: Date = Date(),
    val description: String =  "",
    val image: String = "",
    val longitude: Double = 0.0,
    val latitude: Double = 0.0,
    val price: Double = 0.0,
    val title: String = "",
    val id: Int = 0,
)