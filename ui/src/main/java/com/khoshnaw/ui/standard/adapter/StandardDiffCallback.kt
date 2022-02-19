package com.khoshnaw.ui.standard.adapter

import androidx.recyclerview.widget.DiffUtil

class StandardDiffCallback(
    private val oldList: List<StandardStateListItem>,
    private val newList: List<StandardStateListItem>
) : DiffUtil.Callback() {

    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldList[oldItemPosition].id == newList[newItemPosition].id

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldList[oldItemPosition] == newList[newItemPosition]
}
