package com.khoshnaw.ui.base

import androidx.databinding.ViewDataBinding
import com.khoshnaw.viewmodel.mvi.StandardViewModel

interface MVIView<B : ViewDataBinding, V : StandardViewModel<*, *>> {
    val binding: B
    val viewModel: V
    val viewModelVariableId: Int

    fun onViewReady() = Unit
    fun B.onBindingReady() = Unit
}
