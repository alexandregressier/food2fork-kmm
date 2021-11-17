package dev.gressier.food2fork.data.local

import dev.gressier.food2fork.domain.model.Recipe
import dev.gressier.food2fork.domain.model.RecipeId

interface RecipeCache {
    fun insert(recipe: Recipe)
    fun insert(recipes: List<Recipe>)
    fun getAll(page: Int): List<Recipe>
    fun search(query: String, page: Int): List<Recipe>
    fun get(recipeId: RecipeId): Recipe?
}