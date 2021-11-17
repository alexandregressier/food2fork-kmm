package dev.gressier.food2fork.datasource.network

import dev.gressier.food2fork.datasource.network.model.RecipeDto
import dev.gressier.food2fork.domain.model.Recipe
import dev.gressier.food2fork.util.DateTimeUtil
import io.ktor.client.*
import io.ktor.http.*

expect class KtorClientFactory {
    fun build(): HttpClient
}

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