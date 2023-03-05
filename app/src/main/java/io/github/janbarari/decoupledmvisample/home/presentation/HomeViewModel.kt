package io.github.janbarari.decoupledmvisample.home.presentation

import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.janbarari.decoupledmvisample.home.aser.*
import io.github.janbarari.mvi.ActionHandler
import io.github.janbarari.mvi.BaseViewModel
import javax.inject.Inject
import kotlin.reflect.KClass

@HiltViewModel
class HomeViewModel @Inject constructor(
    homeEffectHandler: HomeEffectHandler,
    private val getWeatherActionHandler: GetWeatherActionHandler,
    private val getTempActionHandler: GetTempActionHandler
) : BaseViewModel<HomeAction, HomeState, HomeEffect, HomeReducer>(
    homeEffectHandler,
    HomeState.Default
) {
    override fun getActionHandlers(): Set<Pair<KClass<out HomeAction>, ActionHandler<*, HomeState, HomeEffect, HomeReducer>>> {
        return setOf(
            HomeAction.LoadWeatherButtonClicked::class to getWeatherActionHandler,
            HomeAction.LoadTempButtonClicked::class to getTempActionHandler
        )
    }
}
