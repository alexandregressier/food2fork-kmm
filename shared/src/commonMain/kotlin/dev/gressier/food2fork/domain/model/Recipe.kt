package dev.gressier.food2fork.domain.model

import io.ktor.http.*
import kotlinx.datetime.LocalDateTime

typealias RecipeId = Int

data class Recipe(
    val id: RecipeId,
    val title: String,
    val publisher: String,
    val featuredImageUrl: Url,
    val rating: Int,
    val sourceUrl: Url,
    val ingredients: List<String> = listOf(),
    val addedAt: LocalDateTime,
    val updatedAt: LocalDateTime,
) {
    companion object
}