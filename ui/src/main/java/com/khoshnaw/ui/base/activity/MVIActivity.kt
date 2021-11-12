package com.khoshnaw.ui.base.activity

import android.os.Bundle
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import com.khoshnaw.ui.BR
import com.khoshnaw.ui.base.MVIView

abstract class MVIActivity<B : ViewDataBinding, V : ViewModel> :
    BaseActivity(),
    MVIView<B, V> {

    override val viewModelVariableId = BR.viewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.setVariable(viewModelVariableId, viewModel)
    }

}
