package dev.gressier.food2fork.android.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.gressier.food2fork.android.AppContext
import dev.gressier.food2fork.datasource.cache.*
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CacheModule {

    @Singleton
    @Provides
    fun provideRecipeDatabase(appContext: AppContext): RecipeDatabase =
        RecipeDatabaseFactory(DriverFactory(appContext)).create()

    @Singleton
    @Provides
    fun provideRecipeCache(recipeDatabase: RecipeDatabase): RecipeCache =
        RecipeCacheImpl(recipeDatabase)
}