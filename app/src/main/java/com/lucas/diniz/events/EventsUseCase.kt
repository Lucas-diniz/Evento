package com.lucas.diniz.events

import com.lucas.diniz.events.data.EventsRepository
import com.lucas.diniz.events.dto.Events

class EventsUseCase(private val repository: EventsRepository) {

    fun listEvents(): List<Events> {
        return repository.listEvents()
    }

}