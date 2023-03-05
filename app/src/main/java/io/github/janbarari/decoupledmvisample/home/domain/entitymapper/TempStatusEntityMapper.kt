package io.github.janbarari.decoupledmvisample.home.domain.entitymapper

import io.github.janbarari.decoupledmvisample.home.data.response.TempApiResponse
import io.github.janbarari.decoupledmvisample.home.domain.entity.TempStatus
import io.github.janbarari.mvi.Mapper
import javax.inject.Inject

class TempStatusEntityMapper @Inject constructor() : Mapper<TempApiResponse, TempStatus> {
    override fun map(left: TempApiResponse): TempStatus {
        return TempStatus(
            city = left.city,
            status = left.status,
            unit = left.unit
        )
    }
}