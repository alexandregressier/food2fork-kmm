package dev.gressier.food2fork.android.presentation.recipedetails

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import dev.gressier.food2fork.android.presentation.recipelist.RecipeId

@Composable
fun RecipeDetailsScreen(
    recipeId: RecipeId?,
) {
    recipeId?.let {
        Text("Recipe Details for ID = $recipeId")
    }
        ?: Text("ERROR")
}