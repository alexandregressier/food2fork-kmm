package dev.gressier.food2fork.android.presentation.recipelist.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun LoadingCardRecipe(
    colors: List<Color>,
    shimmerCoordinates: Pair<Float, Float>,
    height: Dp,
    gradientWidth: Float,
    padding: Dp,
) {
    val (xShimmer, yShimmer) = shimmerCoordinates
    val shimmer = @Composable { surfaceHeight: Dp ->
        Surface(shape = MaterialTheme.shapes.small) {
            Spacer(
                Modifier
                    .fillMaxWidth()
                    .height(surfaceHeight)
                    .background(
                        Brush.linearGradient(
                            colors,
                            start = Offset(xShimmer - gradientWidth, yShimmer - gradientWidth),
                            end = Offset(xShimmer, yShimmer),
                        )
                    )
            )
        }
    }
    Column(
        Modifier.padding(padding),
        Arrangement.spacedBy(16.dp),
    ) {
        shimmer(height)
        shimmer(height / 10)
    }
}