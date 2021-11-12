package com.khoshnaw.ui.base.fragment

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import com.khoshnaw.ui.BR
import com.khoshnaw.ui.base.MVIView

abstract class MVIFragment<B : ViewDataBinding, V : ViewModel>(@LayoutRes contentLayoutId: Int) :
    BaseFragment(contentLayoutId),
    MVIView<B, V> {

    override val viewModelVariableId = BR.viewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.setVariable(viewModelVariableId, viewModel)
    }

}
