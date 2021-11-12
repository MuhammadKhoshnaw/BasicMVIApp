package com.khoshnaw.viewmodel.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.khoshnaw.viewmodel.mvi.BaseViewModel
import kotlinx.coroutines.channels.Channel
import javax.inject.Inject

class MoviesViewModel @Inject constructor(
) : BaseViewModel<MoviesState, MoviesIntent>() {

    private val _state = MutableLiveData<MoviesState>()

    override val intents: Channel<MoviesIntent> = Channel()
    override val state: LiveData<MoviesState> = _state

}
