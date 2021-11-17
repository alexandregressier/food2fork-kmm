package dev.gressier.food2fork.data.local.model

import dev.gressier.food2fork.data.local.RecipeEntity
import dev.gressier.food2fork.domain.model.Recipe
import dev.gressier.food2fork.util.DateTimeUtil
import io.ktor.http.*

fun RecipeEntity.toRecipe(): Recipe =
    Recipe(
        id.toInt(),
        title,
        publisher,
        Url(featuredImageUrl),
        rating.toInt(),
        Url(sourceUrl),
        ingredients.split(", "),
        DateTimeUtil.toLocalDateTime(addedAt),
        DateTimeUtil.toLocalDateTime(updatedAt),
    )

fun List<RecipeEntity>.toRecipeList(): List<Recipe> =
    map(RecipeEntity::toRecipe)