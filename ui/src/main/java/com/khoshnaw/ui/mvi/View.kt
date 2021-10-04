package com.khoshnaw.ui.mvi

import com.khoshnaw.viewmodel.mvi.State

interface View<S : State> {
    fun render(state: S)
}
