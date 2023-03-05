package io.github.janbarari.decoupledmvisample.home.aser

import io.github.janbarari.decoupledmvisample.home.presentation.state.TempState
import io.github.janbarari.decoupledmvisample.home.presentation.state.WeatherState
import io.github.janbarari.mvi.Reducer

sealed class HomeReducer(
    reducer: Reducer<HomeState>
): Reducer<HomeState> by reducer {

    object OnLoading: HomeReducer(
        {
            it.copy(
                isLoading = true
            )
        }
    )

    data class OnWeatherLoaded(
        val weatherState: WeatherState
    ): HomeReducer(
        {
            it.copy(
                isLoading = false,
                weatherStatus = weatherState.result
            )
        }
    )

    data class OnTempLoaded(
        val tempState: TempState
    ): HomeReducer(
        {
            it.copy(
                isLoading = false,
                tempStatus = tempState.result
            )
        }
    )

}
