package dev.gressier.food2fork.data.remote

import dev.gressier.food2fork.domain.model.Recipe
import dev.gressier.food2fork.domain.model.RecipeId

interface RecipeService {
    suspend fun search(query: String, page: Int): List<Recipe>
    suspend fun get(id: RecipeId): Recipe
}