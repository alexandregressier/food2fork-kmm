package dev.gressier.food2fork.domain.model

import kotlinx.datetime.LocalDateTime

typealias RecipeId = Int

data class Recipe(
    val id: RecipeId,
    val title: String,
    val publisher: String,
    val featuredImageUrl: String,
    val rating: Int,
    val sourceUrl: String,
    val ingredients: List<String> = listOf(),
    val addedAt: LocalDateTime,
    val updatedAt: LocalDateTime,
)