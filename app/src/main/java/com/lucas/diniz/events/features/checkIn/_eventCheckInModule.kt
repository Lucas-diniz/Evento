package com.lucas.diniz.events.features.checkIn

import org.koin.dsl.module

val eventsCheckInModule = module {

    factory { EventCheckInViewModel(get()) }

}


