package com.lucas.diniz.events

import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class EventViewModel : ViewModel() {

    private val _navigate = MutableLiveData<Data>()
    val navigate = _navigate

    internal fun setUpList(){
        _navigate.value = Data(EventType.LIST, null)
    }

    internal fun setUpDetail(id: Int){
        _navigate.value = Data(EventType.DETAIL, bundleOf("id" to id))
    }

    internal fun setUpCheckIn(id: Int){
        _navigate.value = Data(EventType.CHECK_IN, bundleOf("id" to id))
    }

    inner class Data(
        internal val eventType: EventType,
        internal val bundle: Bundle?
    )
}
