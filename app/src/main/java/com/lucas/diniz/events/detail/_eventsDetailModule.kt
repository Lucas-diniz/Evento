package com.lucas.diniz.events.detail

import org.koin.dsl.module

val eventsDetailModule = module {

    factory { EventsDetailViewModel(get()) }

}