package com.khoshnaw.usecase.movie.base

import dagger.Lazy

abstract class UseCase<OutputPort> {
    abstract val outputPort: Lazy<OutputPort>
}
