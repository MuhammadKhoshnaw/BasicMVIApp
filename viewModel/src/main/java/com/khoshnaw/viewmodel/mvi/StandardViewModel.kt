package com.khoshnaw.viewmodel.mvi

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.khoshnaw.controller.Controller
import com.khoshnaw.usecase.movie.base.OutputPort
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.launch
import timber.log.Timber
import kotlin.reflect.full.memberProperties
import kotlin.reflect.jvm.isAccessible

abstract class StandardViewModel<S : MVIState, I : MVIIntent> : MVIViewModel<S, I>() {

    override val intents: Channel<I> = Channel()
    private val _state = MutableLiveData<S>()
    override val state: LiveData<S> = _state

    protected fun <O : OutputPort> O.init() = viewModelScope.launch(Dispatchers.IO) {
        injectOutputPorts()
        consumeIntents()
    }

    private suspend fun <O : OutputPort> O.injectOutputPorts() = this::class.memberProperties.map {
        it.isAccessible = true
        it.getter.call(this)
    }.filterIsInstance<Controller<*, O>>().forEach {
        it.registerOutputPort(this)
    }

    private suspend fun consumeIntents() = intents.consumeAsFlow().collect {
        tryToHandleIntent(it)
    }

    private suspend fun tryToHandleIntent(intent: I) = tryTo {
        handleIntent(intent)
    }

    private suspend fun tryTo(callback: suspend () -> Unit) = try {
        callback()
    } catch (e: Throwable) {
        Timber.e(e)
    }

    protected open suspend fun handleIntent(intent: I): Any = Unit

}
