package com.khoshnaw.viewmodel.main

import com.khoshnaw.viewmodel.mvi.StandardViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : StandardViewModel<MainState, MainIntent>() {
    init {
        init()
    }
}
