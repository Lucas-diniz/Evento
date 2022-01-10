package com.lucas.diniz.events.data

import com.lucas.diniz.events.dto.Events
import retrofit2.Call

class EventsRepository(private val api: EventsApi) {

    fun listEvents(): Call<List<Events>> {
        return api.getListEvents()
    }

}