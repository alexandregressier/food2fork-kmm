package dev.gressier.food2fork.interactors.recipelist

import dev.gressier.food2fork.datasource.network.RecipeService
import dev.gressier.food2fork.domain.model.Recipe
import dev.gressier.food2fork.domain.util.DataState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class SearchRecipes(
    private val recipeService: RecipeService,
) {
    fun execute(page: Int, query: String): Flow<DataState<List<Recipe>>> =
        flow {
            emit(DataState.loading())
            try {
                val recipes = recipeService.search(page, query)
                emit(DataState.data(data = recipes))
            } catch (e: Exception) {
                emit(DataState.error(e.message ?: "Unknown error"))
            }
        }
}