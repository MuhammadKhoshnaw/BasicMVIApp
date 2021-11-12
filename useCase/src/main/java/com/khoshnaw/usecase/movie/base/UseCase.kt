package com.khoshnaw.usecase.movie.base

abstract class UseCase<OutputPort> {
    abstract val outputPort: OutputPort
}
