package io.github.janbarari.decoupledmvisample.home.domain.usecase

import io.github.janbarari.decoupledmvisample.home.domain.entity.WeatherStatus
import io.github.janbarari.decoupledmvisample.home.domain.repository.HomeRepository
import io.github.janbarari.mvi.UseCase
import javax.inject.Inject

class GetWeatherUseCase @Inject constructor(
    private val homeRepository: HomeRepository
) : UseCase<String, WeatherStatus>() {

    override suspend fun execute(input: String): WeatherStatus {
        return homeRepository.getWeather(input)
    }

}