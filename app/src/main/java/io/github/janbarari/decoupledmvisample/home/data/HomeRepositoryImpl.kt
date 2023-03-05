package io.github.janbarari.decoupledmvisample.home.data

import io.github.janbarari.decoupledmvisample.home.data.remote.HomeRemoteDataSource
import io.github.janbarari.decoupledmvisample.home.domain.entity.TempStatus
import io.github.janbarari.decoupledmvisample.home.domain.entity.WeatherStatus
import io.github.janbarari.decoupledmvisample.home.domain.entitymapper.TempStatusEntityMapper
import io.github.janbarari.decoupledmvisample.home.domain.entitymapper.WeatherStatusEntityMapper
import io.github.janbarari.decoupledmvisample.home.domain.repository.HomeRepository
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val remoteDataSource: HomeRemoteDataSource,
    private val weatherStatusEntityMapper: WeatherStatusEntityMapper,
    private val tempStatusEntityMapper: TempStatusEntityMapper
) : HomeRepository {

    override suspend fun getWeather(city: String): WeatherStatus {
        val result = remoteDataSource.getWeather(city)
        return weatherStatusEntityMapper.map(result)
    }

    override suspend fun getTemp(city: String): TempStatus {
        val result = remoteDataSource.getTemp(city)
        return tempStatusEntityMapper.map(result)
    }

}