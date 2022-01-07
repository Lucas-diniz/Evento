package com.lucas.diniz.events.data

import com.lucas.diniz.events.dto.Events

class EventsRepository(private val api: EventsApi) {

    fun listEvents(): List<Events> {
        return api.getListEvents()
    }

}