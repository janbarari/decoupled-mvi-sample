package io.github.janbarari.decoupledmvisample.home.aser

import android.content.Context
import android.widget.Toast
import dagger.hilt.android.qualifiers.ApplicationContext
import io.github.janbarari.mvi.EffectHandler
import javax.inject.Inject

class HomeEffectHandler @Inject constructor(
    @ApplicationContext private val context: Context
) : EffectHandler<HomeEffect>() {
    override suspend fun handleEffect(effect: HomeEffect) {
        when(effect) {
            is HomeEffect.ShowToast -> {
                Toast.makeText(context, effect.message, Toast.LENGTH_LONG).show()
            }
        }
    }
}
