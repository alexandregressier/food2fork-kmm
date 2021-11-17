package dev.gressier.food2fork.android.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.gressier.food2fork.android.AppContext
import dev.gressier.food2fork.data.local.RecipeDatabase
import dev.gressier.food2fork.data.local.RecipeDatabaseFactory
import dev.gressier.food2fork.data.local.SqlDriverFactory
import dev.gressier.food2fork.data.local.daos.RecipeDao
import dev.gressier.food2fork.data.local.daos.RecipeDaoImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalDataModule {

    @Singleton
    @Provides
    fun provideRecipeDatabase(appContext: AppContext): RecipeDatabase =
        RecipeDatabaseFactory(SqlDriverFactory(appContext)).create()

    @Singleton
    @Provides
    fun provideRecipeDao(recipeDatabase: RecipeDatabase): RecipeDao =
        RecipeDaoImpl(recipeDatabase)
}