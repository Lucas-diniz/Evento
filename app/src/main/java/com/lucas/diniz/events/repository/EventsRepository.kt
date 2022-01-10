package com.lucas.diniz.events.repository

import com.lucas.diniz.events.list.dto.Events
import retrofit2.Call

class EventsRepository(private val api: EventsApi) {

    fun listEvents(): Call<List<Events>> {
        return api.getListEvents()
    }

    fun getEvent(id: Int): Call<Events> {
        return api.getEvent(id)
    }

}