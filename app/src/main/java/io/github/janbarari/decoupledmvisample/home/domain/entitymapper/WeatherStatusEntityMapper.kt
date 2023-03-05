package io.github.janbarari.decoupledmvisample.home.domain.entitymapper

import io.github.janbarari.decoupledmvisample.home.data.response.WeatherApiResponse
import io.github.janbarari.decoupledmvisample.home.domain.entity.WeatherStatus
import io.github.janbarari.mvi.Mapper
import javax.inject.Inject

class WeatherStatusEntityMapper @Inject constructor() : Mapper<WeatherApiResponse, WeatherStatus> {
    override fun map(left: WeatherApiResponse): WeatherStatus {
        return WeatherStatus(
            city = left.city,
            status = left.status
        )
    }
}