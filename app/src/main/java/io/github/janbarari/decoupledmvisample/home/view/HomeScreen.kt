package io.github.janbarari.decoupledmvisample.home.view

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import io.github.janbarari.decoupledmvisample.home.aser.HomeAction
import io.github.janbarari.decoupledmvisample.home.presentation.HomeViewModel
import io.github.janbarari.decoupledmvisample.theme.DecoupledMVISampleTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun MainScreen() {
    val viewModel: HomeViewModel = viewModel()
    val coroutineScope = rememberCoroutineScope()
    val state by viewModel.state.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Munich, Germany", fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(48.dp))

        if (state.isLoading) {
            Text(text = "Loading...")
            Spacer(modifier = Modifier.height(72.dp))
        } else {
            Text(text = "Weather")
            Text(text = state.weatherStatus)
            Spacer(modifier = Modifier.height(24.dp))
            Text(text = "Temp")
            Text(text = state.tempStatus)
            Spacer(modifier = Modifier.height(48.dp))
        }

        if (state.isLoading.not()) {
            Button(
                onClick = {
                    coroutineScope.launch {
                        viewModel.action(HomeAction.LoadWeatherButtonClicked("Munich"))
                    }
                }
            ) {
                Text(text = "Get Weather")
            }

            Button(onClick = {
                coroutineScope.launch {
                    viewModel.action(HomeAction.LoadTempButtonClicked("Munich"))
                }
            }) {
                Text(text = "Get Temp")
            }
        }
    }

}
