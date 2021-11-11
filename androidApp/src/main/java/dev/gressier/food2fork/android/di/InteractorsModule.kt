package dev.gressier.food2fork.android.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.gressier.food2fork.datasource.network.RecipeService
import dev.gressier.food2fork.interactors.recipelist.SearchRecipes
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object InteractorsModule {

    @Singleton
    @Provides
    fun provideSearchRecipes(recipeService: RecipeService): SearchRecipes =
        SearchRecipes(recipeService)
}