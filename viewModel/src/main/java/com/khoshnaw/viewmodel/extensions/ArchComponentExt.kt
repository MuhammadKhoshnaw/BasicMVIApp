package com.khoshnaw.viewmodel.extensions

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.khoshnaw.viewmodel.base.Event
import com.khoshnaw.viewmodel.base.EventObserver


fun <T> LifecycleOwner.observeEvent(liveData: LiveData<Event<T>>, action: (data: T) -> Unit) {
    liveData.observe(this, EventObserver { it?.let { data -> action(data) } })
}

fun <T : Any> MutableLiveData<Event<T>>.trigger(content: T) {
    postValue(Event(content))
}
