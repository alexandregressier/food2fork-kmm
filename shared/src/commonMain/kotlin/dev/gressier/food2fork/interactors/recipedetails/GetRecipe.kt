package dev.gressier.food2fork.interactors.recipedetails

import dev.gressier.food2fork.datasource.network.RecipeService
import dev.gressier.food2fork.domain.model.Recipe
import dev.gressier.food2fork.domain.model.RecipeId
import dev.gressier.food2fork.domain.util.RequestState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetRecipe(
    private val recipeService: RecipeService,
) {
    fun execute(id: RecipeId): Flow<RequestState<Recipe>> =
        flow {
            emit(RequestState.Loading)
            try {
                val recipe = recipeService.get(id)
                emit(RequestState.Success(recipe))
            } catch (e: Exception) {
                emit(RequestState.Error(e))
            }
        }
}