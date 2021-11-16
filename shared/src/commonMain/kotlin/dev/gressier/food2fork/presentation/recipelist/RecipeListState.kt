package dev.gressier.food2fork.presentation.recipelist

import com.soywiz.kds.Queue
import dev.gressier.food2fork.domain.model.Recipe

data class RecipeListState(
    val isLoading: Boolean = false,
    val query: String = "",
    val selectedFoodCategory: FoodCategory? = null,
    val page: Int = 1,
    val recipes: List<Recipe> = listOf(),
    val errorQueue: Queue<Throwable> = Queue()
)