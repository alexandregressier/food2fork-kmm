package dev.gressier.food2fork.android.presentation.recipedetails

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import dev.gressier.food2fork.android.presentation.components.RecipeImage
import dev.gressier.food2fork.domain.model.Recipe

@Composable
fun RecipeDetailsView(
    recipe: Recipe?,
) {
    recipe?.apply {
        Column {
            Text(title)
            RecipeImage(featuredImageUrl, contentDescription = title)
        }
    }
        ?: Text("Loading...")
}