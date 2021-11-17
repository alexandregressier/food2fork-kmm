package dev.gressier.food2fork.android.presentation.recipelist

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import dev.gressier.food2fork.android.presentation.recipelist.components.LoadingRecipeList
import dev.gressier.food2fork.android.presentation.recipelist.components.RecipeCard
import dev.gressier.food2fork.data.remote.RecipeWebServiceImpl.Companion.RECIPE_PAGINATION_PAGE_SIZE
import dev.gressier.food2fork.domain.model.Recipe
import dev.gressier.food2fork.domain.model.RecipeId

@Composable
fun RecipeList(
    isLoading: Boolean,
    recipes: List<Recipe>,
    page: Int,
    onNextPage: () -> Unit,
    onRecipeListItemClick: (RecipeId) -> Unit,
) {
    when {
        recipes.isEmpty() && isLoading -> {
            LoadingRecipeList()
        }
        recipes.isEmpty() -> {
            // No Recipes found
        }
        else -> {
            LazyColumn {
                itemsIndexed(recipes) { i, recipe ->
                    RecipeCard(recipe, onClick = { onRecipeListItemClick(recipe.id) })
                    if (i + 3 >= page * RECIPE_PAGINATION_PAGE_SIZE && !isLoading) {
                        onNextPage()
                    }
                }
            }
        }
    }
}