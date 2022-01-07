package com.lucas.diniz.events

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lucas.diniz.events.dto.Events

class EventsViewModel(private val useCase: EventsUseCase) : ViewModel() {

    private val _events = MutableLiveData<List<Events>>()
    val events: LiveData<List<Events>> = _events

    fun listEvents(){
        useCase.listEvents()
    }

}