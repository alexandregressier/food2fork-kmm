package dev.gressier.food2fork.presentation.recipelist

import dev.gressier.food2fork.presentation.recipelist.model.FoodCategory

sealed class RecipeListEvent {
    object RecipesLoad: RecipeListEvent()
    object NextPage: RecipeListEvent()
    data class QueryChange(val query: String): RecipeListEvent()
    object QueryClear: RecipeListEvent()
    data class FoodCategorySelect(val category: FoodCategory): RecipeListEvent()
    object Search: RecipeListEvent()
}