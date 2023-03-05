package io.github.janbarari.mvi

interface Mapper<L, R> {
    fun map(left: L): R
}
