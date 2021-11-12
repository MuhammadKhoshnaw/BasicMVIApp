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

abstract class BaseViewModel<S : MVIState, I : Intent> :
    ViewModel(),
    MVIViewModel<S, I> {

    protected fun init(): Job = viewModelScope.launch {
        intents.consumeAsFlow().collect { handleIntent(it) }
    }

    open suspend fun handleIntent(intent: I): Any = Unit

}
