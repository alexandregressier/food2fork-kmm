package dev.gressier.food2fork.android.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier

@Composable
fun CircularIndeterminateProgressBar(
    isDisplayed: Boolean,
    verticalBias: Float = -0.3f,
) {
    if (isDisplayed) {
        Box(
            Modifier.fillMaxSize(),
            BiasAlignment(0f, verticalBias),
        ) {
            CircularProgressIndicator(
                color = MaterialTheme.colors.primary,
            )
        }
    }
}