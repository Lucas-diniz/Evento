package com.lucas.diniz.events

import com.lucas.diniz.events.data.EventsApi
import com.lucas.diniz.events.data.EventsRepository
import com.lucas.diniz.events.dto.Events
import com.lucas.diniz.network.RetrofitClient
import org.koin.dsl.module

val eventsModule = module {

    factory { Events() }

    factory { EventsViewModel(get()) }

    factory { EventsUseCase(get()) }

    factory {
        EventsRepository(RetrofitClient.getApi(EventsApi::class.java))
    }
}