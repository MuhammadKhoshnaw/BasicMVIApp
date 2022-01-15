package com.khoshnaw.ui.base

import androidx.databinding.ViewDataBinding
import com.khoshnaw.viewmodel.mvi.BaseViewModel

interface MVIView<B : ViewDataBinding, V : BaseViewModel<*, *>> {
    val binding: B
    val viewModel: V
    val viewModelVariableId: Int

    fun onViewReady() = Unit
    fun B.onBindingReady() = Unit
}
