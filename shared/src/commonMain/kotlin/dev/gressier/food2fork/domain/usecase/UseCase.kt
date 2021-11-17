package dev.gressier.food2fork.domain.usecase

import dev.gressier.food2fork.data.local.dao.RecipeDao
import dev.gressier.food2fork.data.remote.webservice.RecipeWebService
import dev.gressier.food2fork.domain.model.Recipe
import dev.gressier.food2fork.domain.model.RecipeId
import dev.gressier.food2fork.domain.usecase.model.RequestState
import dev.gressier.food2fork.presentation.recipelist.model.FoodCategory
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

object UseCase {

    class SearchRecipes(
        private val recipeWebService: RecipeWebService,
        private val recipeDao: RecipeDao,
    ) {
        operator fun invoke(query: String = "", page: Int): Flow<RequestState<List<Recipe>>> =
            flow {
                emit(RequestState.Loading)
                try {
                    // For error demonstration purposes only
                    if (query == FoodCategory.Bad.name) {
                        throw Exception("Uh oh... You searched for bad recipes. Not cool!")
                    }
                    val remoteRecipes = recipeWebService.search(query, page)
                    recipeDao.insert(remoteRecipes)
                    val localRecipes = recipeDao.run {
                        if (query.isBlank())
                            getAll(page)
                        else
                            search(query, page)
                    }
                    emit(RequestState.Success(localRecipes))

                } catch (e: Exception) {
                    emit(RequestState.Error(e))
                }
            }
    }

    class GetRecipe(
        private val recipeDao: RecipeDao,
    ) {
        operator fun invoke(id: RecipeId): Flow<RequestState<Recipe>> =
            flow {
                emit(RequestState.Loading)
                try {
                    emit(
                        recipeDao.get(id)?.let { recipe ->
                            RequestState.Success(recipe)
                        } ?: RequestState.Empty
                    )
                } catch (e: Exception) {
                    emit(RequestState.Error(e))
                }
            }
    }
}