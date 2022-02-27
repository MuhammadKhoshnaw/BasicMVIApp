package com.khoshnaw.ui.standard.view

import androidx.databinding.ViewDataBinding
import com.khoshnaw.entity.ErrorMessage
import com.khoshnaw.ui.mvi.MVIView
import com.khoshnaw.viewmodel.mvi.MVIState
import com.khoshnaw.viewmodel.standard.StandardViewModel

interface StandardView<B : ViewDataBinding, V : StandardViewModel<*, *>> : MVIView<B, V> {
    fun showError(message: ErrorMessage)
    fun handleState(state: MVIState)
}
