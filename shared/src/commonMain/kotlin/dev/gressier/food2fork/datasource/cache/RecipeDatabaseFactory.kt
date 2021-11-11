package dev.gressier.food2fork.datasource.cache

import com.squareup.sqldelight.db.SqlDriver
import dev.gressier.food2fork.domain.model.Recipe
import dev.gressier.food2fork.domain.util.DateTimeUtil

expect class DriverFactory {
    fun createDriver(): SqlDriver
}

class RecipeDatabaseFactory(
    private val driverFactory: DriverFactory,
) {
    fun create(): RecipeDatabase =
        RecipeDatabase(driverFactory.createDriver())
}

fun RecipeEntity.toRecipe(): Recipe =
     Recipe(
         id.toInt(),
         title,
         publisher,
         featuredImageUrl,
         rating.toInt(),
         sourceUrl,
         ingredients.split(", "),
         DateTimeUtil.toLocalDateTime(addedAt),
         DateTimeUtil.toLocalDateTime(updatedAt),
    )

fun List<RecipeEntity>.toRecipeList(): List<Recipe> =
    map(RecipeEntity::toRecipe)