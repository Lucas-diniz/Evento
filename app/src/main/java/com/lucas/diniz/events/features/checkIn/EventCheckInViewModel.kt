package com.lucas.diniz.events.features.checkIn

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lucas.diniz.events.EventsUseCase
import com.lucas.diniz.events.dto.Events
import com.lucas.diniz.events.features.checkIn.data.EventCheckInRequest
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EventCheckInViewModel(private val useCase: EventsUseCase) : ViewModel() {

    private val _checkIn = MutableLiveData<String?>()
    val checkIn: LiveData<String?> = _checkIn

    fun registerCheckIn(checkIn: EventCheckInRequest){
        useCase.registerCheckIn(checkIn).enqueue(object : Callback<String> {
            override fun onResponse(call: Call<String>, response: Response<String>) {
                _checkIn.value = response.body()
            }

            override fun onFailure(call: Call<String>, t: Throwable) {
                _checkIn.value = null
            }
        })
    }

}