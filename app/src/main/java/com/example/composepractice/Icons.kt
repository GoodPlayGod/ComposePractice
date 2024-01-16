package com.example.composepractice

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

@Composable
fun rememberCloud(): ImageVector {
    return remember {
        ImageVector.Builder(
            name = "cloud",
            defaultWidth = 40.0.dp,
            defaultHeight = 40.0.dp,
            viewportWidth = 40.0f,
            viewportHeight = 40.0f
        ).apply {
            path(
                fill = SolidColor(Color.Black),
                fillAlpha = 1f,
                stroke = null,
                strokeAlpha = 1f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(10.667f, 33.083f)
                quadToRelative(-3.625f, 0f, -6.167f, -2.521f)
                quadToRelative(-2.542f, -2.52f, -2.542f, -6.145f)
                quadToRelative(0f, -3.209f, 2.021f, -5.646f)
                quadTo(6f, 16.333f, 9.125f, 15.792f)
                quadToRelative(0.875f, -3.917f, 3.917f, -6.375f)
                quadToRelative(3.041f, -2.459f, 7f, -2.459f)
                quadToRelative(4.666f, 0f, 7.875f, 3.334f)
                quadToRelative(3.208f, 3.333f, 3.208f, 8f)
                verticalLineToRelative(0.791f)
                quadToRelative(2.917f, -0.041f, 4.917f, 2f)
                quadToRelative(2f, 2.042f, 2f, 5f)
                quadToRelative(0f, 2.875f, -2.063f, 4.938f)
                quadToRelative(-2.062f, 2.062f, -4.937f, 2.062f)
                close()
                moveToRelative(0f, -2.625f)
                horizontalLineToRelative(20.375f)
                quadToRelative(1.791f, 0f, 3.083f, -1.291f)
                quadToRelative(1.292f, -1.292f, 1.292f, -3.084f)
                quadToRelative(0f, -1.833f, -1.292f, -3.104f)
                quadToRelative(-1.292f, -1.271f, -3.083f, -1.271f)
                horizontalLineToRelative(-2.584f)
                verticalLineToRelative(-3.416f)
                quadToRelative(0f, -3.625f, -2.479f, -6.167f)
                reflectiveQuadToRelative(-6.021f, -2.542f)
                quadToRelative(-3.583f, 0f, -6.083f, 2.542f)
                reflectiveQuadToRelative(-2.5f, 6.167f)
                horizontalLineToRelative(-0.792f)
                quadToRelative(-2.5f, 0f, -4.25f, 1.75f)
                reflectiveQuadToRelative(-1.75f, 4.333f)
                quadToRelative(0f, 2.542f, 1.771f, 4.313f)
                quadToRelative(1.771f, 1.77f, 4.313f, 1.77f)
                close()
                moveTo(20f, 20f)
                close()
            }
        }.build()
    }
}