package dev.gressier.food2fork.android.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.gressier.food2fork.datasource.cache.RecipeCache
import dev.gressier.food2fork.datasource.network.RecipeService
import dev.gressier.food2fork.domain.usecases.UseCase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCasesModule {

    @Singleton
    @Provides
    fun provideSearchRecipes(
        recipeService: RecipeService,
        recipeCache: RecipeCache,
    ): UseCase.SearchRecipes =
        UseCase.SearchRecipes(recipeService, recipeCache)

    @Singleton
    @Provides
    fun provideGetRecipe(
        recipeCache: RecipeCache,
    ): UseCase.GetRecipe =
        UseCase.GetRecipe(recipeCache)
}