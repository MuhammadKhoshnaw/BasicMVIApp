package com.khoshnaw.viewmodel.mvi

import android.app.Application
import androidx.lifecycle.*
import com.khoshnaw.viewmodel.base.Intent
import com.khoshnaw.viewmodel.base.MVIState
import com.khoshnaw.viewmodel.base.MVIViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.launch
import timber.log.Timber

abstract class BaseViewModel<S : MVIState, I : Intent>(
) : ViewModel(),
    MVIViewModel<S, I> {

    override val intents: Channel<I> = Channel()
    private val _state = MutableLiveData<S>()
    override val state: LiveData<S> = _state

    protected fun init(): Job = viewModelScope.launch(Dispatchers.IO) {
        intents.consumeAsFlow().collect { tryToHandleIntent(it) }
    }

    protected suspend fun tryToHandleIntent(intent: I) = try {
        handleIntent(intent)
    } catch (e: Throwable) {
        Timber.e(e)
    }

    open suspend fun handleIntent(intent: I): Any = Unit

}
