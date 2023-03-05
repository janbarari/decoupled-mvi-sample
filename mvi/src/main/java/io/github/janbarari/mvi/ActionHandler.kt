package io.github.janbarari.mvi

import kotlinx.coroutines.flow.Flow
interface ActionHandler<in A, S, E, R: Reducer<S>> {
    fun handle(action: A, state: S, effect: suspend (E) -> Unit): Flow<R>
}
