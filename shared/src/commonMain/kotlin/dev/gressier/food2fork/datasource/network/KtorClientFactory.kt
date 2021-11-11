package dev.gressier.food2fork.datasource.network

import dev.gressier.food2fork.datasource.network.model.RecipeDto
import dev.gressier.food2fork.domain.model.Recipe
import dev.gressier.food2fork.domain.util.DateTimeUtil
import io.ktor.client.*

expect class KtorClientFactory {
    fun build(): HttpClient
}

fun RecipeDto.toRecipe(): Recipe =
    Recipe(
        id = pk,
        title,
        publisher,
        featuredImageUrl = featuredImage,
        rating,
        sourceUrl,
        ingredients,
        addedAt = DateTimeUtil.toLocalDate(longDateAdded.toDouble()),
        updatedAt = DateTimeUtil.toLocalDate(longDateUpdated.toDouble()),
    )

fun List<RecipeDto>.toRecipeList(): List<Recipe> =
    map(RecipeDto::toRecipe)