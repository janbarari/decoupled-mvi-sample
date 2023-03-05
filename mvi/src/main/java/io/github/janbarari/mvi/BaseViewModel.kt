package io.github.janbarari.mvi

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.*
import kotlin.reflect.KClass

abstract class BaseViewModel<A : Any, S : Any, E : Any, R : Reducer<S>>(
    private val effectHandler: EffectHandler<E>,
    initialState: S
) : ViewModel() {
    abstract fun getActionHandlers(): Set<Pair<KClass<out A>, ActionHandler<*, S, E, R>>>

    private val _state = MutableStateFlow(initialState)
    val state: StateFlow<S>
        get() = _state

    val effect: Flow<E>
        get() = effectHandler.effects

    @Suppress("UNCHECKED_CAST")
    suspend fun action(action: A) {
        (getActionHandlers()
            .find { it.first == action::class }
            ?.second as? ActionHandler<A, S, E, R>)
            ?.handle(action, _state.value) { effect ->
                effectHandler.handleEffect(effect)
            }?.cancellable()
            ?.collect { reducer ->
                _state.update { reducer.reduce(_state.value) }
            }
    }
}
