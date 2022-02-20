package com.khoshnaw.viewmodel.standard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.khoshnaw.controller.base.Controller
import com.khoshnaw.usecase.movie.base.OutputPort
import com.khoshnaw.viewmodel.mvi.MVIIntent
import com.khoshnaw.viewmodel.mvi.MVIState
import com.khoshnaw.viewmodel.mvi.MVIViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.launch
import timber.log.Timber
import kotlin.reflect.full.memberProperties
import kotlin.reflect.jvm.isAccessible

@Suppress("MemberVisibilityCanBePrivate")
abstract class StandardViewModel<S : MVIState, I : MVIIntent> : MVIViewModel<S, I>() {

    override val intents: Channel<I> by lazy {
        Channel<I>().tryToConsume()
    }
    private val _state = MutableLiveData<S>()
    override val state: LiveData<S> = _state
    val error = Channel<String>()

    init {
        tryToInjectOutputPorts()
    }

    //region intent
    private fun Channel<I>.tryToConsume(): Channel<I> {
        launchInIO { tryTo { consumeAsFlow().collect { tryToHandleIntent(it) } } }
        return this@tryToConsume
    }

    private suspend fun tryToHandleIntent(intent: I) = tryTo {
        handleIntent(intent)
    }

    protected open suspend fun handleIntent(intent: I): Any = Unit
    //endregion intent

    //region injection
    private fun <O : OutputPort> O.tryToInjectOutputPorts() {
        launchInIO { tryTo { injectOutputPorts() } }
    }

    private fun <O : OutputPort> O.injectOutputPorts() = this::class.memberProperties.map {
        it.isAccessible = true
        it.getter.call(this)
    }.filterIsInstance<Controller<*, O>>().forEach {
        launchInIO { it.registerOutputPort(this@injectOutputPorts) }
    }
    //endregion injection

    //region error
    open fun sendError(e: Throwable) = sendError("some thing went wrong")

    open fun sendError(message: String) {
        viewModelScope.launch { error.send(message) }
    }
    //endregion error

    //region utils
    protected suspend fun tryTo(callback: suspend () -> Unit) = try {
        callback()
    } catch (e: Throwable) {
        Timber.e(e)
        sendError(e)
    }

    protected fun <T> Flow<T>.collectResult(
        action: suspend (value: T) -> Unit
    ) = launchInIO { tryTo { collect { action(it) } } }

    protected fun updateState(state: S) = _state.postValue(state)

    protected fun launchInIO(
        start: CoroutineStart = CoroutineStart.DEFAULT,
        block: suspend CoroutineScope.() -> Unit
    ) = viewModelScope.launch(
        context = Dispatchers.IO,
        start = start,
        block = block,
    )
    //endregion utils
}
