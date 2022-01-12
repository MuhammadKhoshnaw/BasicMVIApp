package com.khoshnaw.viewmodel.mvi

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.khoshnaw.controller.Controller
import com.khoshnaw.usecase.movie.base.OutputPort
import com.khoshnaw.viewmodel.base.Intent
import com.khoshnaw.viewmodel.base.MVIState
import com.khoshnaw.viewmodel.base.MVIViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.launch
import timber.log.Timber
import kotlin.reflect.full.memberProperties
import kotlin.reflect.jvm.isAccessible

abstract class BaseViewModel<S : MVIState, I : Intent>(
) : ViewModel(),
    MVIViewModel<S, I>,
    OutputPort {

    override val intents: Channel<I> = Channel()
    private val _state = MutableLiveData<S>()
    override val state: LiveData<S> = _state

    protected fun <O : OutputPort> O.init() = viewModelScope.launch(Dispatchers.IO) {
        injectOutPutPorts()
        intents.consumeAsFlow().collect { tryToHandleIntent(it) }
    }

    private suspend fun <O : OutputPort> O.injectOutPutPorts() {
        val viewModel = this
        val outputPort = this
        viewModel::class.memberProperties.map {
            it.isAccessible = true
            it.getter.call(viewModel)
        }.filterIsInstance<Controller<*, O>>().forEach {
            it.registerOutPutPort(outputPort)
        }
    }

    private suspend fun tryToHandleIntent(intent: I) = try {
        handleIntent(intent)
    } catch (e: Throwable) {
        Timber.e(e)
    }

    open suspend fun handleIntent(intent: I): Any = Unit

}
