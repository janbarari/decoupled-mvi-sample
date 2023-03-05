package io.github.janbarari.mvi

abstract class UseCase<I, O> {
    abstract suspend fun execute(input: I): O
}
