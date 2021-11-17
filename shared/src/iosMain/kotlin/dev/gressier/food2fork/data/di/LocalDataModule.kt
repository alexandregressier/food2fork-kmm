package dev.gressier.food2fork.data.di

import dev.gressier.food2fork.data.local.RecipeDatabase
import dev.gressier.food2fork.data.local.RecipeDatabaseFactory
import dev.gressier.food2fork.data.local.SqlDriverFactory
import dev.gressier.food2fork.data.local.daos.RecipeDao
import dev.gressier.food2fork.data.local.daos.RecipeDaoImpl

object LocalDataModule {

    val recipeDatabase: RecipeDatabase by lazy {
        RecipeDatabaseFactory(SqlDriverFactory()).create()
    }

    val recipeDao: RecipeDao by lazy {
        RecipeDaoImpl(recipeDatabase)
    }
}