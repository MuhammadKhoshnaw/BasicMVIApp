package com.khoshnaw.usecase.movie.base

abstract class UseCase<O : OutputPort> {
    protected abstract val outputPort: O
}
