package dev.gressier.food2fork.android.presentation.recipedetails

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import dev.gressier.food2fork.domain.model.Recipe

@Composable
fun RecipeDetailsView(
    recipe: Recipe?,
) {
    recipe?.apply {
        Text(title)
    }
        ?: Text("Loading...")
}