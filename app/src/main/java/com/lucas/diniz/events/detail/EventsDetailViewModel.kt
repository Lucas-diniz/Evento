package com.lucas.diniz.events.detail

import androidx.lifecycle.ViewModel
import com.lucas.diniz.events.EventsUseCase

class EventsDetailViewModel(private val useCase: EventsUseCase) : ViewModel() {


    fun getEventDetail(id: Int){
        useCase.getDetails(id)
    }

}