package com.khoshnaw.viewmodel.mvi

import androidx.lifecycle.LiveData
import kotlinx.coroutines.channels.Channel

interface IVMViewModel<S : State, I : Intent> {
    val intents: Channel<I>
    val state: LiveData<S>
}
