package dev.gressier.food2fork.data.remote.model

import dev.gressier.food2fork.domain.model.Recipe
import dev.gressier.food2fork.util.DateTimeUtil
import io.ktor.http.*

fun RecipeDto.toRecipe(): Recipe =
    Recipe(
        id = pk,
        title,
        publisher,
        featuredImageUrl = Url(featuredImage),
        rating,
        Url(sourceUrl),
        ingredients,
        addedAt = DateTimeUtil.toLocalDateTime(longDateAdded.toDouble()),
        updatedAt = DateTimeUtil.toLocalDateTime(longDateUpdated.toDouble()),
    )

fun List<RecipeDto>.toRecipeList(): List<Recipe> =
    map(RecipeDto::toRecipe)