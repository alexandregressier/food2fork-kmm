package dev.gressier.food2fork.android.presentation.recipedetails

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import dev.gressier.food2fork.domain.model.Recipe

@Composable
fun RecipeDetailsView(
    recipe: Recipe?,
) {
    recipe?.apply {
        Text(title, style = MaterialTheme.typography.headlineMedium)
    }
        ?: Text("Loading...")
}