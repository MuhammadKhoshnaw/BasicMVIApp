package com.khoshnaw.ui.standard.adapter

import androidx.databinding.ViewDataBinding
import androidx.lifecycle.findViewTreeLifecycleOwner
import androidx.lifecycle.lifecycleScope
import com.khoshnaw.ui.extenstion.runIntentInScope
import com.khoshnaw.ui.mvi.MVIHolder
import com.khoshnaw.viewmodel.mvi.MVIIntent
import com.khoshnaw.viewmodel.mvi.MVIViewModel

abstract class StandardHolder<in I : StandardStateListItem>(
    private val binding: ViewDataBinding
) : MVIHolder<I>(binding) {

    fun <I : MVIIntent> MVIViewModel<*, I>.runIntent(intent: I) {
        runIntentInScope(binding.root.findViewTreeLifecycleOwner()?.lifecycleScope, intent)
    }

}
