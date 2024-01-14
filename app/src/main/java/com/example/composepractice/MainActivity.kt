package com.example.composepractice

import android.os.Bundle
import android.content.Context
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.composepractice.theme.ComposePracticeTheme
import com.example.composepractice.ui.MainScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePracticeTheme {
                GreetingView()
            }
        }
    }
}


@Composable
fun GreetingView() {
    Surface(
        modifier = Modifier
            .background(Color.Green)
            .fillMaxSize()
    ) {
        Image(
            painterResource(R.drawable.clouds),
            "Background image",
            contentScale = ContentScale.FillHeight
        )
        Column(
            modifier = Modifier,
            verticalArrangement = Arrangement.Center
        ) {
            MainScreen("Moscow", LocalContext.current)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GreetingView()
}