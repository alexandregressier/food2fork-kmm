package dev.gressier.food2fork.interactors.recipedetails

import dev.gressier.food2fork.datasource.cache.RecipeCache
import dev.gressier.food2fork.domain.model.Recipe
import dev.gressier.food2fork.domain.model.RecipeId
import dev.gressier.food2fork.domain.util.RequestState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetRecipe(
    private val recipeCache: RecipeCache,
) {
    fun execute(id: RecipeId): Flow<RequestState<Recipe>> =
        flow {
            emit(RequestState.Loading)
            try {
                emit(
                    recipeCache.get(id)?.let { recipe ->
                        RequestState.Success(recipe)
                    } ?: RequestState.Empty
                )
            } catch (e: Exception) {
                emit(RequestState.Error(e))
            }
        }
}