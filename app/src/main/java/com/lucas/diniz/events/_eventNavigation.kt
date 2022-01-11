package com.lucas.diniz.events

import com.lucas.diniz.R
import com.lucas.diniz.events.EventType.*


internal fun EventType.id() =
    when (this) {
        LIST -> R.id.event_list
        DETAIL -> R.id.event_detail
        CHECK_IN -> R.id.event_check_in
    }

enum class EventType {
    LIST,
    DETAIL,
    CHECK_IN
}

