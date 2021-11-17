package dev.gressier.food2fork.android.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.gressier.food2fork.android.AppContext
import dev.gressier.food2fork.data.local.*
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
    fun provideRecipeDao(recipeDatabase: RecipeDatabase): RecipeDao =
        RecipeDaoImpl(recipeDatabase)
}