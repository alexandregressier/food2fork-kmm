package dev.gressier.food2fork.android.presentation.recipedetails.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.gressier.food2fork.android.presentation.components.RecipeImage
import dev.gressier.food2fork.domain.model.Recipe
import dev.gressier.food2fork.domain.util.DateTimeUtil

@Composable
fun RecipeView(
    recipe: Recipe,
) {
    LazyColumn(Modifier.fillMaxWidth()) {
        item {
            recipe.apply {
                RecipeImage(url = featuredImageUrl, contentDescription = title)
                Column(
                    Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                ) {
                    Row(Modifier.fillMaxWidth()) {
                        Text(
                            title,
                            Modifier
                                .fillMaxWidth(0.85f)
                                .wrapContentWidth(Alignment.Start),
                            style = MaterialTheme.typography.h3,
                        )
                        Text(
                            "$rating",
                            Modifier
                                .fillMaxWidth()
                                .wrapContentWidth(Alignment.End)
                                .align(Alignment.CenterVertically),
                            style = MaterialTheme.typography.h5,
                        )
                    }
                    Text(
                        "Updated on ${DateTimeUtil.humanizeDatetime(updatedAt)} by $publisher",
                        Modifier.fillMaxWidth(),
                        style = MaterialTheme.typography.caption,
                    )
                    Column {
                        ingredients.forEach { ingredient ->
                            Text(
                                ingredient,
                                Modifier.fillMaxWidth(),
                                style = MaterialTheme.typography.body1,
                            )
                        }
                    }
                }
            }
        }
    }
}