package com.lucas.diniz.events

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import com.lucas.diniz.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class EventsActivity : AppCompatActivity() {

    private val eventViewModel: EventViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        setupNavigation()
    }

    private fun setupNavigation() {
        eventViewModel.navigate.observe(this, Observer {
            Navigation.findNavController(this, R.id.root_event_navigation)
                .navigate(it.eventType.id(), it.bundle)
        })
    }

    override fun onBackPressed() {
        super.onBackPressed()
        eventViewModel.setUpList()
    }
}