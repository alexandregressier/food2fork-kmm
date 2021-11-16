package dev.gressier.food2fork.android.presentation.recipelist.components

import androidx.compose.animation.core.*
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import dev.gressier.food2fork.android.R

@Composable
fun LoadingRecipeList(
    imageHeight: Dp = dimensionResource(R.dimen.recipeImage_height),
    padding: Dp = 16.dp,
) {
    BoxWithConstraints(Modifier.fillMaxSize()) {
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
        val shimmerCoordinates = Pair(animation(cardWidthPx), animation(cardHeightPx))
        val colors = listOf(
            Color.LightGray.copy(alpha = .9f),
            Color.LightGray.copy(alpha = .3f),
            Color.LightGray.copy(alpha = .9f),
        )
        LazyColumn {
            items(5) {
                LoadingCardRecipe(colors, shimmerCoordinates, imageHeight, gradientWidth, padding)
            }
        }
    }
}