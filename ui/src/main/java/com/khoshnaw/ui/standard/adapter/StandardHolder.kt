package com.khoshnaw.ui.standard.adapter

import androidx.databinding.ViewDataBinding
import com.khoshnaw.ui.base.adapter.BaseHolder

abstract class StandardHolder<in I : StandardListItem>(
    binding: ViewDataBinding
) : BaseHolder<I>(binding)
