package com.lucas.diniz.events

import com.lucas.diniz.events.repository.EventsRepository
import com.lucas.diniz.events.dto.Events
import com.lucas.diniz.events.features.checkIn.data.EventCheckInRequest
import retrofit2.Call

class EventsUseCase(private val repository: EventsRepository) {

    fun listEvents(): Call<List<Events>> {
        return repository.listEvents()
    }

    fun getDetails(id: Int): Call<Events> {
        return repository.getEvent(id)
    }

    fun registerCheckIn(checkIn: EventCheckInRequest): Call<String> {
        return repository.registerCheckIn(checkIn)
    }

}