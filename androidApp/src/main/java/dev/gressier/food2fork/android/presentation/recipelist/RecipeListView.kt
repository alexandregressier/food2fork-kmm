package dev.gressier.food2fork.android.presentation.recipelist

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

typealias RecipeId = Int

@Composable
fun RecipeListView(
    onRecipeSelect: (RecipeId) -> Unit = {},
) {
    LazyColumn {
        items(100) {
            val recipeId = it + 1
            Row(
                Modifier
                    .fillMaxWidth()
                    .clickable {
                        onRecipeSelect(recipeId)
                    }
            ) {
                Text("Recipe ID = $recipeId", Modifier.padding(16.dp))
            }
        }
    }
}