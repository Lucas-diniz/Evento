package com.lucas.diniz.events.data

import com.lucas.diniz.events.dto.Events
import retrofit2.Call
import retrofit2.http.GET

interface EventsApi {

    @GET("events")
    fun getListEvents(): Call<List<Events>>

}