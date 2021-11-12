package com.khoshnaw.ui.base

import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel

interface MVIView<B : ViewDataBinding, V : ViewModel> {
    val binding: B
    val viewModel: V
    val viewModelVariableId: Int
}
