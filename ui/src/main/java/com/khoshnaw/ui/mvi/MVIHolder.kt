package com.khoshnaw.ui.mvi

import androidx.databinding.ViewDataBinding
import com.khoshnaw.ui.base.adapter.BaseHolder
import com.khoshnaw.ui.base.adapter.StateListItem

abstract class MVIHolder<in I : StateListItem>(
    binding: ViewDataBinding
) : BaseHolder(binding.root) {

    abstract fun bind(item: I)

}
