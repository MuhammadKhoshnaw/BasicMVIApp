package com.khoshnaw.ui.extenstion

import androidx.lifecycle.LifecycleCoroutineScope
import com.khoshnaw.usecase.utils.tryTo
import com.khoshnaw.viewmodel.mvi.MVIIntent
import com.khoshnaw.viewmodel.mvi.MVIViewModel
import kotlinx.coroutines.launch
import timber.log.Timber

fun <I : MVIIntent> MVIViewModel<*, I>.runIntentInScope(
    scope: LifecycleCoroutineScope?,
    intent: I
) {
    scope?.launch {
        val exception = tryTo { intents.send(intent) }
        Timber.e(exception)
    }
}
