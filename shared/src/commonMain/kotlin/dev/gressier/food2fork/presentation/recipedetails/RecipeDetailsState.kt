package dev.gressier.food2fork.presentation.recipedetails

import dev.gressier.food2fork.domain.model.Recipe

data class RecipeDetailsState(
    val isLoading: Boolean = false,
    val recipe: Recipe? = null,
)