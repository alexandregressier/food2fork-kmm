package dev.gressier.food2fork.android.presentation.recipedetails.components

import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import dev.gressier.food2fork.android.R

@Composable
fun LoadingRecipeView(
    imageHeight: Dp = dimensionResource(R.dimen.recipeImage_height),
    padding: Dp = 16.dp,
) {
    BoxWithConstraints(
        Modifier
            .fillMaxSize()
            .padding(padding),
    ) {
        val cardWidthPx = with(LocalDensity.current) { (maxWidth - padding * 2).toPx() }
        val cardHeightPx = with(LocalDensity.current) { (imageHeight - padding).toPx() }
        val gradientWidth = 0.2f * cardHeightPx

        val infiniteTransition = rememberInfiniteTransition()
        val animation = @Composable { targetValue: Float ->
            infiniteTransition.animateFloat(
                initialValue = 0f,
                targetValue = targetValue + gradientWidth,
                animationSpec = infiniteRepeatable(tween(1300, 300, LinearEasing), RepeatMode.Restart),
            ).value
        }
        val (xShimmer, yShimmer) = Pair(animation(cardWidthPx), animation(cardHeightPx))
        val colors = listOf(
            Color.LightGray.copy(alpha = .9f),
            Color.LightGray.copy(alpha = .3f),
            Color.LightGray.copy(alpha = .9f),
        )
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
        Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
            shimmer(imageHeight)
            repeat(3) {
                shimmer(imageHeight / 10)
            }
        }
    }
}