package com.khoshnaw.ui.mvi

import androidx.databinding.ViewDataBinding
import com.khoshnaw.ui.base.activity.BaseActivity
import com.khoshnaw.viewmodel.standard.StandardViewModel

abstract class MVIActivity<B : ViewDataBinding, V : StandardViewModel<*, *>> :
    BaseActivity(),
    MVIView<B, V>
