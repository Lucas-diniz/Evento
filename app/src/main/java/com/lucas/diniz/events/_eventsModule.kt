package com.lucas.diniz.events

import com.lucas.diniz.events.list.dto.Events
import com.lucas.diniz.events.repository.EventsApi
import com.lucas.diniz.events.repository.EventsRepository
import com.lucas.diniz.network.RetrofitClient
import org.koin.dsl.module

val eventsListModule = module {

    factory { Events() }

    factory { EventsUseCase(get()) }

    factory {
        EventsRepository(RetrofitClient.getApi(EventsApi::class.java))
    }
}