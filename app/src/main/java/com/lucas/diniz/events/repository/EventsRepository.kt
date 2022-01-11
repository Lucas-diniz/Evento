package com.lucas.diniz.events.repository

import com.lucas.diniz.events.dto.Events
import com.lucas.diniz.events.features.checkIn.data.EventCheckInRequest
import retrofit2.Call

class EventsRepository(private val api: EventsApi) {

    fun listEvents(): Call<List<Events>> {
        return api.getListEvents()
    }

    fun getEvent(id: Int): Call<Events> {
        return api.getEvent(id)
    }

    fun registerCheckIn(checkIn: EventCheckInRequest): Call<String>{
        return api.registerCheckIn(checkIn)
    }

}