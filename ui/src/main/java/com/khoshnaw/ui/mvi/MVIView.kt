package com.khoshnaw.ui.mvi

import androidx.databinding.ViewDataBinding
import com.khoshnaw.viewmodel.mvi.MVIViewModel

interface MVIView<B : ViewDataBinding, V : MVIViewModel<*, *>> {
    val binding: B
    val viewModel: V
    val viewModelVariableId: Int

    fun onViewReady()
}
