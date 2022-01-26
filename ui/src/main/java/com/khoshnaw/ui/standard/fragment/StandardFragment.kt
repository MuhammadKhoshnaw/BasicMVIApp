package com.khoshnaw.ui.standard.fragment

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.lifecycleScope
import com.khoshnaw.ui.BR
import com.khoshnaw.ui.mvi.MVIFragment
import com.khoshnaw.ui.standard.view.StandardView
import com.khoshnaw.viewmodel.extensions.observeEvent
import com.khoshnaw.viewmodel.mvi.MVIIntent
import com.khoshnaw.viewmodel.mvi.MVIState
import com.khoshnaw.viewmodel.mvi.MVIViewModel
import com.khoshnaw.viewmodel.standard.StandardViewModel
import kotlinx.coroutines.launch

abstract class StandardFragment<B : ViewDataBinding, V : StandardViewModel<*, *>>(
    @LayoutRes contentLayoutId: Int
) : MVIFragment<B, V>(contentLayoutId), StandardView<B, V> {

    override val viewModelVariableId = BR.viewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.setVariable(viewModelVariableId, viewModel)
        viewModel.observeState()
        viewModel.observeError()
        onViewReady()
    }

    fun <S : MVIState, I : MVIIntent> MVIViewModel<S, I>.runIntent(intent: I) {
        lifecycleScope.launch {
            intents.send(intent)
        }
    }

    private fun V.observeState() = state.observe(viewLifecycleOwner) { it?.let { handleState(it) } }

    private fun V.observeError() = observeEvent(error) { showError(it) }

    override fun showError(message: String) {
        if (activity is StandardView<*, *>) (activity as StandardView<*, *>).showError(message)
    }

    override fun onViewReady() = Unit
    override fun handleState(state: MVIState) = Unit
}
