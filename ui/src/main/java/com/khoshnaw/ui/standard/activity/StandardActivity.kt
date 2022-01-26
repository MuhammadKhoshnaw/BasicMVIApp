package com.khoshnaw.ui.standard.activity

import android.os.Bundle
import androidx.databinding.ViewDataBinding
import com.google.android.material.snackbar.Snackbar
import com.khoshnaw.ui.BR
import com.khoshnaw.ui.mvi.MVIActivity
import com.khoshnaw.ui.standard.view.StandardView
import com.khoshnaw.viewmodel.extensions.observeEvent
import com.khoshnaw.viewmodel.mvi.MVIState
import com.khoshnaw.viewmodel.standard.StandardViewModel

abstract class StandardActivity<B : ViewDataBinding, V : StandardViewModel<*, *>> :
    MVIActivity<B, V>(), StandardView<B, V> {

    override val viewModelVariableId = BR.viewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.setVariable(viewModelVariableId, viewModel)
        viewModel.observeState()
        viewModel.observeError()
        onViewReady()
    }

    private fun V.observeState() =
        state.observe(this@StandardActivity) { it?.let { handleState(it) } }

    private fun V.observeError() = observeEvent(error) { showError(it) }

    override fun showError(message: String) =
        Snackbar.make(binding.root, message, Snackbar.LENGTH_SHORT).show()

    override fun onViewReady() = Unit
    override fun handleState(state: MVIState) = Unit

}
