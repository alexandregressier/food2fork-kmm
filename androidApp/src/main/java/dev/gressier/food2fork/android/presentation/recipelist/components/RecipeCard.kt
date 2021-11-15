package dev.gressier.food2fork.android.presentation.recipelist.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import dev.gressier.food2fork.android.R
import dev.gressier.food2fork.android.presentation.components.RecipeImage
import dev.gressier.food2fork.domain.model.Recipe
import dev.gressier.food2fork.domain.util.Example

@Composable
fun RecipeCard(
    recipe: Recipe,
    onClick: () -> Unit = {},
) {
    Card(
        onClick,
        Modifier
            .fillMaxWidth()
            .padding(vertical = dimensionResource(R.dimen.recipeCard_padding)),
        MaterialTheme.shapes.small,
        elevation = dimensionResource(R.dimen.recipeCard_padding),
    ) {
        recipe.apply {
            Column {
                RecipeImage(featuredImageUrl, contentDescription = title)
                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(
                            horizontal = dimensionResource(R.dimen.recipeCard_row_horizontalPadding),
                            vertical = dimensionResource(R.dimen.recipeCard_row_verticalPadding),
                        ),
                ) {
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
                            .align(CenterVertically),
                        style = MaterialTheme.typography.h5,
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun RecipeCard_Preview() {
    RecipeCard(Recipe.Example)
}