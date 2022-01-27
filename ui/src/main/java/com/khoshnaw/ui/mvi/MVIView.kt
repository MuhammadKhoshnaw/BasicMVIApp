package com.khoshnaw.ui.mvi

import androidx.databinding.ViewDataBinding
import com.khoshnaw.viewmodel.standard.StandardViewModel

interface MVIView<B : ViewDataBinding, V : StandardViewModel<*, *>> {
    val binding: B
    val viewModel: V
    val viewModelVariableId: Int

    fun onViewReady()
}
