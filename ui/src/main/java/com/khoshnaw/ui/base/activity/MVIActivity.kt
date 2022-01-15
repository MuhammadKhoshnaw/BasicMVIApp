package com.khoshnaw.ui.base.activity

import android.os.Bundle
import androidx.databinding.ViewDataBinding
import com.khoshnaw.ui.BR
import com.khoshnaw.ui.base.MVIView
import com.khoshnaw.viewmodel.mvi.BaseViewModel

abstract class MVIActivity<B : ViewDataBinding, V : BaseViewModel<*, *>> :
    BaseActivity(),
    MVIView<B, V> {

    override val viewModelVariableId = BR.viewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.setVariable(viewModelVariableId, viewModel)
    }

}
