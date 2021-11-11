package dev.gressier.food2fork.interactors.recipelist

import dev.gressier.food2fork.datasource.network.RecipeService
import dev.gressier.food2fork.domain.model.Recipe
import dev.gressier.food2fork.domain.util.RequestState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class SearchRecipes(
    private val recipeService: RecipeService,
) {
    fun execute(page: Int, query: String): Flow<RequestState<List<Recipe>>> =
        flow {
            emit(RequestState.Loading)
            try {
                val recipes = recipeService.search(page, query)
                emit(RequestState.Success(recipes))
            } catch (e: Exception) {
                emit(RequestState.Error(e))
            }
        }
}