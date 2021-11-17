package dev.gressier.food2fork.interactors.recipelist

import dev.gressier.food2fork.datasource.cache.RecipeCache
import dev.gressier.food2fork.datasource.network.RecipeService
import dev.gressier.food2fork.domain.model.Recipe
import dev.gressier.food2fork.interactors.RequestState
import dev.gressier.food2fork.presentation.recipelist.FoodCategory
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class SearchRecipes(
    private val recipeService: RecipeService,
    private val recipeCache: RecipeCache,
) {
    fun execute(query: String = "", page: Int): Flow<RequestState<List<Recipe>>> =
        flow {
            emit(RequestState.Loading)
            try {
                if (query == FoodCategory.Bad.name) {
                    throw Exception("Uh oh... You searched for bad recipes. Not cool!")
                }
                val recipes = recipeService.search(query, page)
                recipeCache.insert(recipes)
                val cachedRecipes = recipeCache.run {
                    if (query.isBlank())
                        getAll(page)
                    else
                        search(query, page)
                }
                emit(RequestState.Success(cachedRecipes))

            } catch (e: Exception) {
                emit(RequestState.Error(e))
            }
        }
}