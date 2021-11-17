package dev.gressier.food2fork.data.local.model

import dev.gressier.food2fork.data.local.RecipeEntity
import dev.gressier.food2fork.domain.model.Recipe
import dev.gressier.food2fork.util.DateTimeUtil
import io.ktor.http.*

fun RecipeEntity.toRecipe(): Recipe =
    Recipe(
        id = id.toInt(),
        title,
        publisher,
        featuredImageUrl = Url(featuredImageUrl),
        rating = rating.toInt(),
        sourceUrl = Url(sourceUrl),
        ingredients = ingredients.split(", "),
        addedAt = DateTimeUtil.toLocalDateTime(addedAt),
        updatedAt = DateTimeUtil.toLocalDateTime(updatedAt),
    )

fun List<RecipeEntity>.toRecipeList(): List<Recipe> =
    map(RecipeEntity::toRecipe)