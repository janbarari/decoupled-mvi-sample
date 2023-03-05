package io.github.janbarari.decoupledmvisample.home.data.remote

import io.github.janbarari.decoupledmvisample.home.data.response.TempApiResponse
import io.github.janbarari.decoupledmvisample.home.data.response.WeatherApiResponse
import kotlinx.coroutines.delay
import javax.inject.Inject
import kotlin.random.Random

class HomeRemoteDataSourceImpl @Inject constructor(): HomeRemoteDataSource {

    override suspend fun getWeather(city: String): WeatherApiResponse {
        delay(2000)
        val weatherConditions = listOf("Cloudy", "Sunny", "Rainy")
        val randomIndex = Random.nextInt(weatherConditions.size)
        return WeatherApiResponse(city, weatherConditions[randomIndex])
    }

    override suspend fun getTemp(city: String): TempApiResponse {
        delay(2000)
        val tempConditions = listOf(15, 20, 25)
        val randomIndex = Random.nextInt(tempConditions.size)
        return TempApiResponse(city, tempConditions[randomIndex], "°C")
    }
}
