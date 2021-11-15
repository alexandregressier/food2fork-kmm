package dev.gressier.food2fork.android.presentation.recipelist

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import dev.gressier.food2fork.android.presentation.components.CircularIndeterminateProgressBar
import dev.gressier.food2fork.android.presentation.theme.Gray1
import dev.gressier.food2fork.domain.model.RecipeId
import dev.gressier.food2fork.presentation.recipelist.RecipeListState

@Composable
fun RecipeListView(
    state: RecipeListState,
    onRecipeListItemClick: (RecipeId) -> Unit = {},
) {
    Box(
        Modifier
            .fillMaxSize()
            .background(color = Gray1),
    ) {
        state.apply {
            if (isLoading) {
                CircularIndeterminateProgressBar(isDisplayed = isLoading)
            }
            RecipeList(isLoading, recipes, onRecipeListItemClick)
        }
    }
}