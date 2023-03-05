package io.github.janbarari.mvi

fun interface Reducer<S> {
    fun reduce(state: S): S
}
