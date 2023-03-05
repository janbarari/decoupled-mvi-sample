package io.github.janbarari.decoupledmvisample.home.data.remote

import io.github.janbarari.decoupledmvisample.home.data.response.TempApiResponse
import io.github.janbarari.decoupledmvisample.home.data.response.WeatherApiResponse

interface HomeRemoteDataSource {
    suspend fun getWeather(city: String): WeatherApiResponse
    suspend fun getTemp(city: String): TempApiResponse
}