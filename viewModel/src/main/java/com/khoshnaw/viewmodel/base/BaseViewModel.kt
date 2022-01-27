package com.khoshnaw.viewmodel.base

import androidx.lifecycle.ViewModel
import com.khoshnaw.usecase.movie.base.OutputPort

abstract class BaseViewModel : ViewModel(), OutputPort
