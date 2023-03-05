package io.github.janbarari.decoupledmvisample.home.domain.usecase

import io.github.janbarari.decoupledmvisample.home.domain.entity.TempStatus
import io.github.janbarari.decoupledmvisample.home.domain.entity.WeatherStatus
import io.github.janbarari.decoupledmvisample.home.domain.repository.HomeRepository
import io.github.janbarari.mvi.UseCase
import javax.inject.Inject

class GetTempUseCase @Inject constructor(
    private val homeRepository: HomeRepository
) : UseCase<String, TempStatus>() {

    override suspend fun execute(input: String): TempStatus {
        return homeRepository.getTemp(input)
    }

}