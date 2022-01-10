package com.lucas.diniz.events.list

import com.lucas.diniz.events.EventsUseCase
import com.lucas.diniz.events.list.adapter.EventAdapter
import org.koin.dsl.module

val eventsModule = module {

    factory { EventsViewModel(get()) }

    factory { EventAdapter() }

}