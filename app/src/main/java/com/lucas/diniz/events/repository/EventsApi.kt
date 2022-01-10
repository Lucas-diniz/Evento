package com.lucas.diniz.events.repository

import com.lucas.diniz.events.list.dto.Events
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface EventsApi {

    @GET("events")
    fun getListEvents(): Call<List<Events>>

    @GET("events?")
    fun getEvent(
        @Query("id") id: Int,
    ): Call<Events>

}