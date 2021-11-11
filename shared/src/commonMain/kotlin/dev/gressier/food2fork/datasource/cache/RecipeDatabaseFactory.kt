package dev.gressier.food2fork.datasource.cache

import com.squareup.sqldelight.db.SqlDriver

expect class DriverFactory {
    fun createDriver(): SqlDriver
}

class RecipeDatabaseFactory(
    private val driverFactory: DriverFactory,
) {
    fun create(): RecipeDatabase =
        RecipeDatabase(driverFactory.createDriver())
}