package com.khoshnaw.viewmodel.base

import androidx.lifecycle.LiveData
import kotlinx.coroutines.channels.Channel

interface MVIViewModel<S : MVIState, I : Intent> {
    val intents: Channel<I>
    val state: LiveData<S>
}
