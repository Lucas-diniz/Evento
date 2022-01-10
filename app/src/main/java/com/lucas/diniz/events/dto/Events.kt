package com.lucas.diniz.events.dto

data class Events(
    val people: List<String> = listOf(),
    val date: Long = 0,
    val description: String =  "",
    val image: String = "",
    val longitude: Double = 0.0,
    val latitude: Double = 0.0,
    val price: Double = 0.0,
    val title: String = "",
    val id: Int = 0,
)