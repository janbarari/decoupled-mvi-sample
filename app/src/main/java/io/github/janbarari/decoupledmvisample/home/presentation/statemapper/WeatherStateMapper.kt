package io.github.janbarari.decoupledmvisample.home.presentation.statemapper

import io.github.janbarari.decoupledmvisample.home.domain.entity.WeatherStatus
import io.github.janbarari.decoupledmvisample.home.presentation.state.WeatherState
import io.github.janbarari.mvi.Mapper
import javax.inject.Inject

class WeatherStateMapper @Inject constructor() : Mapper<WeatherStatus, WeatherState> {
    override fun map(left: WeatherStatus): WeatherState {
        return WeatherState(
            result = "Weather in ${left.city} is ${left.status}"
        )
    }
}