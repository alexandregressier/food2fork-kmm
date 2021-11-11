package dev.gressier.food2fork.datasource.network

import dev.gressier.food2fork.domain.model.Recipe
import dev.gressier.food2fork.domain.model.RecipeId

interface RecipeService {
    suspend fun search(page: Int, query: String): List<Recipe>
    suspend fun get(id: RecipeId): Recipe
}