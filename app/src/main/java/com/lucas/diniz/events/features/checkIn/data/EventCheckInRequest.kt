package com.lucas.diniz.events.features.checkIn.data

data class EventCheckInRequest (
    val eventId: Int = 0,
    val name: String = "",
    val email: String = ""
)