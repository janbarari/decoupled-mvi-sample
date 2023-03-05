package io.github.janbarari.decoupledmvisample.home.domain.repository

import io.github.janbarari.decoupledmvisample.home.domain.entity.TempStatus
import io.github.janbarari.decoupledmvisample.home.domain.entity.WeatherStatus

interface HomeRepository {
    suspend fun getWeather(city: String): WeatherStatus
    suspend fun getTemp(city: String): TempStatus
}