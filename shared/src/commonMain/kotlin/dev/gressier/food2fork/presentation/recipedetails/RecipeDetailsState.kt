package dev.gressier.food2fork.presentation.recipedetails

import dev.gressier.food2fork.domain.model.Recipe
import dev.gressier.food2fork.domain.util.Queue
import dev.gressier.food2fork.domain.util.emptyQueue
import dev.gressier.food2fork.presentation.model.VisibleMessage

data class RecipeDetailsState(
    val isLoading: Boolean = false,
    val recipe: Recipe? = null,
    val messages: Queue<VisibleMessage> = emptyQueue(),
)