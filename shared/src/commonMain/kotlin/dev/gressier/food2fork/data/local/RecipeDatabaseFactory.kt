package dev.gressier.food2fork.data.local

class RecipeDatabaseFactory(
    private val sqlDriverFactory: SqlDriverFactory,
) {
    fun create(): RecipeDatabase =
        RecipeDatabase(sqlDriverFactory.createDriver())
}