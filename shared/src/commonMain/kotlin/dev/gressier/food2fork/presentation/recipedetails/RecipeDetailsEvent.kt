package dev.gressier.food2fork.presentation.recipedetails

import dev.gressier.food2fork.domain.model.RecipeId

sealed class RecipeDetailsEvent {
    data class RecipeLoad(val recipeId: RecipeId): RecipeDetailsEvent()
}