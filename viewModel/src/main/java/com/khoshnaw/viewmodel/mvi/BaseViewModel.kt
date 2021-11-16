package com.khoshnaw.viewmodel.mvi

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.khoshnaw.viewmodel.base.Intent
import com.khoshnaw.viewmodel.base.MVIState
import com.khoshnaw.viewmodel.base.MVIViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.launch
import timber.log.Timber

abstract class BaseViewModel<S : MVIState, I : Intent> :
    ViewModel(),
    MVIViewModel<S, I> {

    protected fun init(): Job = viewModelScope.launch {
        intents.consumeAsFlow().collect { tryToHandleIntent(it) }
    }

    private suspend fun tryToHandleIntent(intent: I) = try {
        handleIntent(intent)
    } catch (e: Throwable) {
        Timber.e(e)
    }

    open suspend fun handleIntent(intent: I): Any = Unit

}
