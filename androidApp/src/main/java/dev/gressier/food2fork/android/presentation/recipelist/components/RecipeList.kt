package dev.gressier.food2fork.android.presentation.recipelist

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import dev.gressier.food2fork.android.presentation.recipelist.components.RecipeCard
import dev.gressier.food2fork.domain.model.Recipe
import dev.gressier.food2fork.domain.model.RecipeId

@Composable
fun RecipeList(
    isLoading: Boolean,
    recipes: List<Recipe>,
    onRecipeListItemClick: (RecipeId) -> Unit,
) {
    when {
        recipes.isEmpty() && isLoading -> {
            // Loading Recipes
        }
        recipes.isEmpty() -> {
            // No Recipes found
        }
        else -> {
            LazyColumn {
                items(recipes) { recipe ->
                    RecipeCard(recipe, onClick = { onRecipeListItemClick(recipe.id) })
                }
            }
        }
    }
}