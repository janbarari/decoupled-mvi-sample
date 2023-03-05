package io.github.janbarari.decoupledmvisample.home.aser

import io.github.janbarari.decoupledmvisample.home.domain.usecase.GetTempUseCase
import io.github.janbarari.decoupledmvisample.home.domain.usecase.GetWeatherUseCase
import io.github.janbarari.decoupledmvisample.home.presentation.statemapper.TempStateMapper
import io.github.janbarari.decoupledmvisample.home.presentation.statemapper.WeatherStateMapper
import io.github.janbarari.mvi.ActionHandler
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetTempActionHandler @Inject constructor(
    private val getTempUseCase: GetTempUseCase,
    private val tempStateMapper: TempStateMapper
) : ActionHandler<HomeAction.LoadTempButtonClicked, HomeState, HomeEffect, HomeReducer> {
    override fun handle(
        action: HomeAction.LoadTempButtonClicked,
        state: HomeState,
        effect: suspend (HomeEffect) -> Unit
    ): Flow<HomeReducer> {
        return flow {
            emit(HomeReducer.OnLoading)
            val tempState = tempStateMapper.map(getTempUseCase.execute(action.city))
            emit(HomeReducer.OnTempLoaded(tempState))
        }
    }
}
