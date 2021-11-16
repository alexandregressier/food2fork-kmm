package dev.gressier.food2fork.presentation.recipelist

sealed class RecipeListEvent {
    object LoadRecipes: RecipeListEvent()
    object NextPage: RecipeListEvent()
}