package io.github.janbarari.mvi

import kotlinx.coroutines.flow.MutableSharedFlow

abstract class EffectHandler<E> {
    val effects = MutableSharedFlow<E>(replay = 0)
    abstract suspend fun handleEffect(effect: E)
}