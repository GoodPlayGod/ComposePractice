package com.example.composepractice.ui

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateMap
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composepractice.getData
import com.example.composepractice.rememberCloud
import com.example.composepractice.theme.labelLarge
import com.example.composepractice.theme.titleMedium
import com.example.composepractice.theme.titleSmall

const val API_KEY = "2a590caf324a4ce5912130317231112"
const val city = "Moscow"

@Composable
fun MainScreen(context: Context) {
    val state = remember {
        mutableStateMapOf(
            "Temperature" to "None",
            "Cloudy" to "None",
            "Wind speed" to "None",
            "Humidity" to "None",
            "UF level" to "None"
        )
    }
    Column(
        modifier = Modifier
            .background(Color.Transparent)
            .fillMaxHeight(0.8f)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Москва", style = MaterialTheme.typography.titleMedium)
        Text(text = state["Температура"].toString(), style = MaterialTheme.typography.labelLarge)
        Text(
            text = "Облачность\n ${state["Облачность"].toString()}",
            style = MaterialTheme.typography.titleMedium
        )
        WeatherInfo(state)
        TemperaturePerHour(state)
        RefreshButton(context, state)
    }
}

@Composable
fun WeatherInfo(state: SnapshotStateMap<String, String>) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Скорость ветра\n ${state["Скорость ветра"].toString()}",
            style = MaterialTheme.typography.titleSmall
        )
        Text(
            text = "Влажность\n ${state["Влажноссть"].toString()}",
            style = MaterialTheme.typography.titleSmall,
            modifier = Modifier.padding(5.dp)
        )
        Text(
            text = "Уровень УФ\n ${state["Уровень УФ"]}",
            style = MaterialTheme.typography.titleSmall
        )
    }
}


@Composable
fun TemperaturePerHour(state: SnapshotStateMap<String, String>) {
    Row(
        modifier = Modifier.horizontalScroll(rememberScrollState()),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        for (i: Int in 0..23)
            Column (modifier = Modifier,
            horizontalAlignment = Alignment.CenterHorizontally){
                Text(
                    text = i.toString(),
                    style = MaterialTheme.typography.titleSmall,
                    modifier = Modifier.padding(5.dp)
                )

                Text(
                    text = state["Температура"].toString(),
                    style = MaterialTheme.typography.titleSmall,
                    modifier = Modifier.padding(5.dp)
                )
            }
    }
}

@Composable
fun RefreshButton(context: Context, state: SnapshotStateMap<String, String>) {
    Button(onClick = {
        getData("Moscow", context, state)
    }) {
        Text(text = "Жмак", style = MaterialTheme.typography.titleMedium)
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    MainScreen(LocalContext.current)
}
