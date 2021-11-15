package dev.gressier.food2fork.android.presentation.recipelist

import androidx.compose.runtime.Composable
import dev.gressier.food2fork.domain.model.RecipeId
import dev.gressier.food2fork.presentation.recipelist.RecipeListState

@Composable
fun RecipeListView(
    state: RecipeListState,
    onRecipeListItemClick: (RecipeId) -> Unit = {},
) {
    state.apply {
        RecipeList(isLoading, recipes, onRecipeListItemClick)
    }
}