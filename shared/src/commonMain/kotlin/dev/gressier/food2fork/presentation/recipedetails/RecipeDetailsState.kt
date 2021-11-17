package dev.gressier.food2fork.presentation.recipedetails

import dev.gressier.food2fork.domain.model.Recipe
import dev.gressier.food2fork.presentation.model.VisibleMessage
import dev.gressier.food2fork.util.Queue
import dev.gressier.food2fork.util.emptyQueue

data class RecipeDetailsState(
    val isLoading: Boolean = false,
    val recipe: Recipe? = null,
    val messages: Queue<VisibleMessage> = emptyQueue(),
)