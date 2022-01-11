package com.lucas.diniz.events.features.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lucas.diniz.events.EventsUseCase
import com.lucas.diniz.events.dto.Events
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EventsDetailViewModel(private val useCase: EventsUseCase) : ViewModel() {

    private val _events = MutableLiveData<Events?>()
    val events: LiveData<Events?> = _events

    fun getEventDetail(id: Int){
        useCase.getDetails(id).enqueue(object : Callback<Events> {
            override fun onResponse(call: Call<Events>, response: Response<Events>) {
                _events.value = response.body()
            }

            override fun onFailure(call: Call<Events>, t: Throwable) {
                _events.value = null
            }
        })
    }

}