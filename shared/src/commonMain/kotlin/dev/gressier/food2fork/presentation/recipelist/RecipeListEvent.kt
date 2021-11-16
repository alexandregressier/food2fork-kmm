package dev.gressier.food2fork.presentation.recipelist

sealed class RecipeListEvent {
    object RecipesLoad: RecipeListEvent()
    object NextPage: RecipeListEvent()
    data class QueryChange(val query: String): RecipeListEvent()
    object Search: RecipeListEvent()
}