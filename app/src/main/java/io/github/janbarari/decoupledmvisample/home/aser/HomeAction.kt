package io.github.janbarari.decoupledmvisample.home.aser

sealed class HomeAction {
    data class LoadWeatherButtonClicked(val city: String): HomeAction()
    data class LoadTempButtonClicked(val city: String): HomeAction()
}
