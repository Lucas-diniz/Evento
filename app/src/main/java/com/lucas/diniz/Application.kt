package com.lucas.diniz

import android.app.Application
import com.lucas.diniz.events.detail.eventsDetailModule
import com.lucas.diniz.events.eventsListModule
import com.lucas.diniz.events.list.eventsModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class Application : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@Application)
            modules(eventsModule)
            modules(eventsListModule)
            modules(eventsDetailModule)
        }

    }

}