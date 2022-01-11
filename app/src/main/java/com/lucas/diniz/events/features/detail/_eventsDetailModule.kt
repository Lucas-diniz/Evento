package com.lucas.diniz.events.features.detail

import org.koin.dsl.module

val eventsDetailModule = module {

    factory { EventsDetailViewModel(get()) }

}