package com.khoshnaw.ui.mvi

import androidx.annotation.LayoutRes
import androidx.databinding.ViewDataBinding
import com.khoshnaw.ui.base.fragment.BaseFragment
import com.khoshnaw.viewmodel.standard.StandardViewModel

abstract class MVIFragment<B : ViewDataBinding, V : StandardViewModel<*, *>>(
    @LayoutRes contentLayoutId: Int
) : BaseFragment(contentLayoutId),
    MVIView<B, V>
