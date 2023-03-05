package io.github.janbarari.decoupledmvisample.home.aser

import io.github.janbarari.decoupledmvisample.home.domain.usecase.GetWeatherUseCase
import io.github.janbarari.decoupledmvisample.home.presentation.statemapper.WeatherStateMapper
import io.github.janbarari.mvi.ActionHandler
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetWeatherActionHandler @Inject constructor(
    private val getWeatherUseCase: GetWeatherUseCase,
    private val weatherStateMapper: WeatherStateMapper
) : ActionHandler<HomeAction.LoadWeatherButtonClicked, HomeState, HomeEffect, HomeReducer> {
    override fun handle(
        action: HomeAction.LoadWeatherButtonClicked,
        state: HomeState,
        effect: suspend (HomeEffect) -> Unit
    ): Flow<HomeReducer> {
        return flow {
            emit(HomeReducer.OnLoading)
            val weatherState = weatherStateMapper.map(getWeatherUseCase.execute(action.city))
            emit(HomeReducer.OnWeatherLoaded(weatherState))
        }
    }
}
