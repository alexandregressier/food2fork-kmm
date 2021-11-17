package dev.gressier.food2fork.presentation.recipelist

import dev.gressier.food2fork.domain.model.Recipe
import dev.gressier.food2fork.util.Queue
import dev.gressier.food2fork.util.emptyQueue
import dev.gressier.food2fork.presentation.model.VisibleMessage

data class RecipeListState(
    val isLoading: Boolean = false,
    val query: String = "",
    val selectedFoodCategory: FoodCategory? = null,
    val page: Int = 1,
    val recipes: List<Recipe> = emptyList(),
    val messages: Queue<VisibleMessage> = emptyQueue(),
)