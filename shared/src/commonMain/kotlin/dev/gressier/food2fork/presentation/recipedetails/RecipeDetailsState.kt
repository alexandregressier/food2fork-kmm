package dev.gressier.food2fork.presentation.recipedetails

import com.soywiz.kds.Queue
import dev.gressier.food2fork.domain.model.Recipe

data class RecipeDetailsState(
    val isLoading: Boolean = false,
    val recipe: Recipe? = null,
    val errorQueue: Queue<Throwable> = Queue()
)