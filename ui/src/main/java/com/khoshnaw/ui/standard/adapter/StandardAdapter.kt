package com.khoshnaw.ui.standard.adapter

import androidx.recyclerview.widget.DiffUtil
import com.khoshnaw.ui.base.adapter.BaseAdapter
import com.khoshnaw.ui.base.adapter.BaseHolder

abstract class StandardAdapter<I : StandardListItem> : BaseAdapter<BaseHolder<I>>() {
    open var items = listOf<I>()
        set(value) {
            val diffResult = DiffUtil.calculateDiff(StandardDiffCallback(field, value))
            field = value
            diffResult.dispatchUpdatesTo(this)
        }

    override fun getItemCount() = items.size

}
