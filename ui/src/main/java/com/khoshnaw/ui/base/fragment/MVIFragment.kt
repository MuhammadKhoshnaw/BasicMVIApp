package com.khoshnaw.ui.base.fragment

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.lifecycleScope
import com.khoshnaw.ui.BR
import com.khoshnaw.ui.base.MVIView
import com.khoshnaw.viewmodel.base.Intent
import com.khoshnaw.viewmodel.base.MVIState
import com.khoshnaw.viewmodel.mvi.BaseViewModel
import kotlinx.coroutines.launch

abstract class MVIFragment<B : ViewDataBinding, V : BaseViewModel<*, *>>(
    @LayoutRes contentLayoutId: Int
) : BaseFragment(contentLayoutId),
    MVIView<B, V> {

    override val viewModelVariableId = BR.viewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.setVariable(viewModelVariableId, viewModel)
        binding.onBindingReady()
        onViewReady()
    }

    fun <S : MVIState, I : Intent> BaseViewModel<S, I>.runIntent(intent: I) {
        lifecycleScope.launch {
            intents.send(intent)
        }
    }
}
