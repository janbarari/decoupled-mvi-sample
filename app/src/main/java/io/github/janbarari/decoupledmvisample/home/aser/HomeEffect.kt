package io.github.janbarari.decoupledmvisample.home.aser

sealed class HomeEffect {
    data class ShowToast(val message: String): HomeEffect()
}
