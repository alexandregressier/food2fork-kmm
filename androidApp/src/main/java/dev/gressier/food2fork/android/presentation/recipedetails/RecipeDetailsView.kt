package dev.gressier.food2fork.android.presentation.recipedetails

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import dev.gressier.food2fork.android.presentation.components.CircularIndeterminateProgressBar
import dev.gressier.food2fork.android.presentation.recipedetails.components.LoadingRecipeView
import dev.gressier.food2fork.android.presentation.recipedetails.components.RecipeView
import dev.gressier.food2fork.presentation.recipedetails.RecipeDetailsState

@Composable
fun RecipeDetailsView(
    state: RecipeDetailsState,
) {
    state.apply {
        recipe?.let { recipe ->
            RecipeView(recipe)
        }
        if (isLoading) {
            Box {
                LoadingRecipeView()
                CircularIndeterminateProgressBar(isDisplayed = isLoading)
            }
        }
    }
}