package dev.gressier.food2fork.presentation.recipelist

import dev.gressier.food2fork.domain.model.Recipe
import dev.gressier.food2fork.presentation.model.VisibleMessage
import dev.gressier.food2fork.presentation.recipelist.model.FoodCategory
import dev.gressier.food2fork.util.Queue
import dev.gressier.food2fork.util.emptyQueue

data class RecipeListState(
    val isLoading: Boolean,
    val query: String,
    val selectedFoodCategory: FoodCategory?,
    val page: Int,
    val recipes: List<Recipe>,
    val messages: Queue<VisibleMessage>,
) {
    constructor() : this(
        isLoading = false,
        query = "",
        selectedFoodCategory = null,
        page = 1,
        recipes = emptyList(),
        messages = emptyQueue()
    )
}