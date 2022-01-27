package com.khoshnaw.ui.base.adapter

import androidx.databinding.ViewDataBinding
import androidx.lifecycle.findViewTreeLifecycleOwner
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.khoshnaw.ui.extenstion.runIntentInScope
import com.khoshnaw.viewmodel.mvi.MVIIntent
import com.khoshnaw.viewmodel.mvi.MVIViewModel

abstract class BaseHolder<in I : ListItem>(
    private val binding: ViewDataBinding
) : RecyclerView.ViewHolder(binding.root) {
    abstract fun bind(item: I)

    fun <I : MVIIntent> MVIViewModel<*, I>.runIntent(intent: I) {
        runIntentInScope(binding.root.findViewTreeLifecycleOwner()?.lifecycleScope, intent)
    }
}

