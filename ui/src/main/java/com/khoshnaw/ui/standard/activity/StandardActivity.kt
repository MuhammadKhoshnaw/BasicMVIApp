package com.khoshnaw.ui.standard.activity

import android.os.Bundle
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.lifecycleScope
import com.google.android.material.snackbar.Snackbar
import com.khoshnaw.entity.ErrorMessage
import com.khoshnaw.ui.BR
import com.khoshnaw.ui.R
import com.khoshnaw.ui.extenstion.runIntentInScope
import com.khoshnaw.ui.mvi.MVIActivity
import com.khoshnaw.ui.standard.view.StandardView
import com.khoshnaw.viewmodel.mvi.MVIIntent
import com.khoshnaw.viewmodel.mvi.MVIState
import com.khoshnaw.viewmodel.mvi.MVIViewModel
import com.khoshnaw.viewmodel.standard.StandardViewModel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

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

    fun <I : MVIIntent> MVIViewModel<*, I>.runIntent(intent: I) {
        runIntentInScope(lifecycleScope, intent)
    }

    private fun V.observeState() =
        state.observe(this@StandardActivity) { it?.let { handleState(it) } }

    private fun V.observeError() {
        lifecycleScope.launch {
            error.receiveAsFlow().collect { showError(it) }
        }
    }

    override fun showError(message: ErrorMessage) {
        val messageStr = if (message == ErrorMessage.DEFAULT) getString(R.string.default_error)
        else message.message

        showError(messageStr)
    }

    private fun showError(messageStr: String) = Snackbar
        .make(binding.root, messageStr, Snackbar.LENGTH_SHORT)
        .show()

    override fun onViewReady() = Unit
    override fun handleState(state: MVIState) = Unit

}
