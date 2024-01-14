package com.example.composepractice.theme

import androidx.compose.material.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

// Set of Material typography styles to start with
val Typography = Typography(

)

val Typography.labelLarge: TextStyle
    @Composable
    get() {
        return TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Normal,
            color = Color.White,
            fontSize = 60.sp,
            lineHeight = 16.sp,
            letterSpacing = 0.5.sp,
            textAlign = TextAlign.Center
        )
    }

val Typography.titleLarge: TextStyle
    @Composable
    get() {
        return TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Normal,
            color = Color.White,
            fontSize = 30.sp,
            lineHeight = 60.sp,
            letterSpacing = 0.5.sp,
            textAlign = TextAlign.Center
        )
    }

val Typography.titleMedium: TextStyle
    @Composable
    get() {
        return TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Normal,
            color = Color.White,
            fontSize = 22.sp,
            lineHeight = 28.sp,
            letterSpacing = 0.sp,
            textAlign = TextAlign.Center
        )
    }

val Typography.titleSmall: TextStyle
    @Composable
    get() {
        return TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Normal,
            color = Color.White,
            fontSize = 12.sp,
            lineHeight = 16.sp,
            letterSpacing = 0.sp,
            textAlign = TextAlign.Center
        )
    }