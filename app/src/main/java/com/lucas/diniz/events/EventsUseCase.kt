package com.lucas.diniz.events

import com.lucas.diniz.events.data.EventsRepository
import com.lucas.diniz.events.dto.Events
import retrofit2.Call

class EventsUseCase(private val repository: EventsRepository) {

    fun listEvents(): Call<List<Events>> {
        return repository.listEvents()
    }

}