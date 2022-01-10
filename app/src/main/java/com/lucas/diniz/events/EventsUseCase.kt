package com.lucas.diniz.events

import com.lucas.diniz.events.repository.EventsRepository
import com.lucas.diniz.events.list.dto.Events
import retrofit2.Call

class EventsUseCase(private val repository: EventsRepository) {

    fun listEvents(): Call<List<Events>> {
        return repository.listEvents()
    }

    fun getDetails(id: Int){
        repository.getEvent(id)
    }

}