package com.lucas.diniz.events.features.list

import com.lucas.diniz.events.features.list.adapter.EventListAdapter
import com.squareup.picasso.Picasso
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val eventsModule = module {

    factory { EventsListViewModel(get()) }

    factory { EventListAdapter(Picasso.with(androidContext())) }

}