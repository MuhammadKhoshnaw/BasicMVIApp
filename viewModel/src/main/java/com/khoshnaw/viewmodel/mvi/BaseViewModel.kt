package com.khoshnaw.viewmodel.mvi

import androidx.lifecycle.ViewModel
import com.khoshnaw.viewmodel.base.Intent
import com.khoshnaw.viewmodel.base.MVIState
import com.khoshnaw.viewmodel.base.MVIViewModel

abstract class BaseViewModel<S : MVIState, I : Intent> :
    ViewModel(),
    MVIViewModel<S, I>
