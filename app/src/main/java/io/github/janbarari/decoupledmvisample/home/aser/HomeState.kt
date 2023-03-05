package io.github.janbarari.decoupledmvisample.home.aser

data class HomeState(
    val isLoading: Boolean = false,
    val weatherStatus: String = "Unknown",
    val tempStatus: String = "Unknown"
) {

    companion object {
        val Default = HomeState()
    }
}
