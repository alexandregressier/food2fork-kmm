package dev.gressier.composesandbox.ui.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.ViewCompat
import dev.gressier.food2fork.android.presentation.theme.*

private val LightColorScheme = lightColors(
    primary = Blue600,
    primaryVariant = Blue400,
    secondary = Color.White,
    secondaryVariant = Teal300,
    background = Gray1,
    surface = Color.White,
    error = RedErrorDark,
    onPrimary = Black2,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Black2,
    onError = RedErrorLight,
)

private val DarkColorScheme = darkColors()

@Composable
fun Food2ForkTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
//    dynamicColor: Boolean = true,
    content: @Composable () -> Unit,
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            (view.context as Activity).window.statusBarColor = colorScheme.primary.toArgb()
            ViewCompat.getWindowInsetsController(view)?.isAppearanceLightStatusBars = darkTheme
        }
    }

    MaterialTheme(
        colors = colorScheme,
        typography = Typography,
        content = content,
    )
}