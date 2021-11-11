package dev.gressier.food2fork.datasource.cache

import dev.gressier.food2fork.datasource.network.RecipeServiceImpl.Companion.RECIPE_PAGINATION_PAGE_SIZE
import dev.gressier.food2fork.domain.model.Recipe
import dev.gressier.food2fork.domain.model.RecipeId
import dev.gressier.food2fork.domain.util.DateTimeUtil

class RecipeCacheImpl(
    private val recipeDatabase: RecipeDatabase,
) : RecipeCache {

    private val recipeQueries: RecipeDatabaseQueries =
        recipeDatabase.recipeDatabaseQueries

    override fun insert(recipe: Recipe) {
        recipe.apply {
            recipeQueries.insert(
                id.toLong(),
                title,
                publisher,
                featuredImageUrl,
                rating.toLong(),
                sourceUrl,
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
            pageSize = RECIPE_PAGINATION_PAGE_SIZE.toLong(),
            offset = ((page - 1) * RECIPE_PAGINATION_PAGE_SIZE).toLong(),
        )
            .executeAsList()
            .toRecipeList()

    override fun search(query: String, page: Int): List<Recipe> =
        recipeQueries.search(
            query = query,
            pageSize = RECIPE_PAGINATION_PAGE_SIZE.toLong(),
            offset = ((page - 1) * RECIPE_PAGINATION_PAGE_SIZE).toLong(),
        )
            .executeAsList()
            .toRecipeList()

    override fun get(recipeId: RecipeId): Recipe? =
        recipeQueries.selectById(recipeId.toLong()).executeAsOneOrNull()?.toRecipe()
}