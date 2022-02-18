package com.khoshnaw.viewmodel.standard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.khoshnaw.controller.base.Controller
import com.khoshnaw.usecase.movie.base.OutputPort
import com.khoshnaw.viewmodel.mvi.MVIIntent
import com.khoshnaw.viewmodel.mvi.MVIState
import com.khoshnaw.viewmodel.mvi.MVIViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.launch
import timber.log.Timber
import kotlin.reflect.full.memberProperties
import kotlin.reflect.jvm.isAccessible

abstract class StandardViewModel<S : MVIState, I : MVIIntent> : MVIViewModel<S, I>() {

    override val intents: Channel<I> = Channel()
    private val _state = MutableLiveData<S>()
    override val state: LiveData<S> = _state

    val error = Channel<String>()

    protected fun <O : OutputPort> O.init() = viewModelScope.launch(Dispatchers.IO) {
        tryTo {
            injectOutputPorts()
            consumeIntents()
        }
    }

    private suspend fun <O : OutputPort> O.injectOutputPorts() = this::class.memberProperties.map {
        it.isAccessible = true
        it.getter.call(this)
    }.filterIsInstance<Controller<*, O>>().forEach {
        it.registerOutputPort(this)
    }

    private suspend fun consumeIntents() = intents.consumeAsFlow().collect {
        viewModelScope.launch(Dispatchers.IO) { tryToHandleIntent(it) }
    }

    private suspend fun tryToHandleIntent(intent: I) = tryTo {
        handleIntent(intent)
    }

    private suspend fun tryTo(callback: suspend () -> Unit) = try {
        callback()
    } catch (e: Throwable) {
        Timber.e(e)
        sendError(e)
    }

    open fun sendError(e: Throwable) = sendError("some thing went wrong")

    open fun sendError(message: String) {
        viewModelScope.launch {
            error.send(message)
        }
    }

    protected open suspend fun handleIntent(intent: I): Any = Unit

    protected fun <T> Flow<T>.collectResult(
        action: suspend (value: T) -> Unit
    ) = viewModelScope.launch(Dispatchers.Main) { tryTo { collect { action(it) } } }

    protected fun updateState(state: S) {
        _state.postValue(state)
    }
}
