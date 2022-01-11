package com.lucas.diniz.events.repository

import com.lucas.diniz.events.dto.Events
import com.lucas.diniz.events.features.checkIn.data.EventCheckInRequest
import retrofit2.Call
import retrofit2.http.*

interface EventsApi {

    @GET("events")
    fun getListEvents(): Call<List<Events>>

    @GET("events/{id}")
    fun getEvent(
        @Path("id") id: Int,
    ): Call<Events>

    @Headers("Content-Type: application/json")
    @POST("checkin")
    fun registerCheckIn(
        @Body eventCheckInRequest: EventCheckInRequest,
    ): Call<String>

}