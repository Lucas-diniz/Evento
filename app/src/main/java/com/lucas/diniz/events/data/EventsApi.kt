package com.lucas.diniz.events.data

import androidx.lifecycle.LiveData
import com.lucas.diniz.events.dto.Events
import retrofit2.http.GET

interface EventsApi {

    @GET("mobile/agenda/v1/lista")
    fun getListEvents(): List<Events>

}