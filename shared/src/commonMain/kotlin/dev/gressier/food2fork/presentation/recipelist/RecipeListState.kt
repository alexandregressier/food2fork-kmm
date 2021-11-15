package dev.gressier.food2fork.presentation.recipelist

import dev.gressier.food2fork.domain.model.Recipe

data class RecipeListState(
    val isLoading: Boolean = false,
    val query: String = "",
    val page: Int = 1,
    val recipes: List<Recipe> = listOf(),
)