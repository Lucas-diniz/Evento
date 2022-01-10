package com.lucas.diniz.events

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lucas.diniz.events.dto.Events
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EventsViewModel(private val useCase: EventsUseCase) : ViewModel() {

    private val _listEvents = MutableLiveData<List<Events>?>()
    val listEvents: LiveData<List<Events>?> = _listEvents

    fun listEvents() {

        useCase.listEvents()
            .enqueue(object : Callback<List<Events>> {

                override fun onResponse(
                    call: Call<List<Events>>,
                    response: Response<List<Events>>
                ) {
                    if (response.isSuccessful) {
                        _listEvents.value = response.body()
                    } else {
                        _listEvents.value = null
                    }
                }

                override fun onFailure(call: Call<List<Events>>, t: Throwable) {
                    _listEvents.value = null
                }
            })

    }

    companion object {
        const val ERROR_LOAD_EVENTS = "load data error"
    }
}