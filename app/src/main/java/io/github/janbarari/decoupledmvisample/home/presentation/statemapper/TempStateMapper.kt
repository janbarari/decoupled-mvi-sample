package io.github.janbarari.decoupledmvisample.home.presentation.statemapper

import io.github.janbarari.decoupledmvisample.home.domain.entity.TempStatus
import io.github.janbarari.decoupledmvisample.home.domain.entity.WeatherStatus
import io.github.janbarari.decoupledmvisample.home.presentation.state.TempState
import io.github.janbarari.decoupledmvisample.home.presentation.state.WeatherState
import io.github.janbarari.mvi.Mapper
import javax.inject.Inject

class TempStateMapper @Inject constructor() : Mapper<TempStatus, TempState> {
    override fun map(left: TempStatus): TempState {
        return TempState(
            result = "Temp in ${left.city} is ${left.status} ${left.unit}"
        )
    }
}