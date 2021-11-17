package dev.gressier.food2fork.data.local.daos

import dev.gressier.food2fork.data.local.RecipeDatabase
import dev.gressier.food2fork.data.local.RecipeQueries
import dev.gressier.food2fork.data.local.model.toRecipe
import dev.gressier.food2fork.data.local.model.toRecipeList
import dev.gressier.food2fork.data.remote.webservices.RecipeWebServiceImpl
import dev.gressier.food2fork.domain.model.Recipe
import dev.gressier.food2fork.domain.model.RecipeId
import dev.gressier.food2fork.util.DateTimeUtil

interface RecipeDao {
    fun insert(recipe: Recipe)
    fun insert(recipes: List<Recipe>)
    fun getAll(page: Int): List<Recipe>
    fun search(query: String, page: Int): List<Recipe>
    fun get(recipeId: RecipeId): Recipe?
}

class RecipeDaoImpl(
    recipeDatabase: RecipeDatabase,
) : RecipeDao {

    private val recipeQueries: RecipeQueries =
        recipeDatabase.recipeQueries

    override fun insert(recipe: Recipe) {
        recipe.apply {
            recipeQueries.insert(
                id.toLong(),
                title,
                publisher,
                featuredImageUrl.toString(),
                rating.toLong(),
                sourceUrl.toString(),
                ingredients.joinToString(),
                DateTimeUtil.toEpochMilliseconds(addedAt),
                DateTimeUtil.toEpochMilliseconds(updatedAt),
            )
        }
    }

    override fun insert(recipes: List<Recipe>) {
        recipes.forEach(this::insert)
    }

    override fun getAll(page: Int): List<Recipe> =
        recipeQueries.selectAll(
            pageSize = RecipeWebServiceImpl.RECIPE_PAGINATION_PAGE_SIZE.toLong(),
            offset = ((page - 1) * RecipeWebServiceImpl.RECIPE_PAGINATION_PAGE_SIZE).toLong(),
        )
            .executeAsList()
            .toRecipeList()

    override fun search(query: String, page: Int): List<Recipe> =
        recipeQueries.search(
            query = query,
            pageSize = RecipeWebServiceImpl.RECIPE_PAGINATION_PAGE_SIZE.toLong(),
            offset = ((page - 1) * RecipeWebServiceImpl.RECIPE_PAGINATION_PAGE_SIZE).toLong(),
        )
            .executeAsList()
            .toRecipeList()

    override fun get(recipeId: RecipeId): Recipe? =
        recipeQueries.selectById(recipeId.toLong()).executeAsOneOrNull()?.toRecipe()
}