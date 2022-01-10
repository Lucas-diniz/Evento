package com.lucas.diniz.events

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lucas.diniz.R
import com.lucas.diniz.events.list.EventsListFragment

class EventsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)


        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, EventsListFragment.newInstance())
                .commitNow()
        }

    }
}