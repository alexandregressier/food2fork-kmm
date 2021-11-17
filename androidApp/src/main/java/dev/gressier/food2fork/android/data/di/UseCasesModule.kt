package dev.gressier.food2fork.android.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.gressier.food2fork.data.local.RecipeCache
import dev.gressier.food2fork.data.remote.RecipeWebService
import dev.gressier.food2fork.domain.usecases.UseCase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCasesModule {

    @Singleton
    @Provides
    fun provideSearchRecipes(
        recipeWebService: RecipeWebService,
        recipeCache: RecipeCache,
    ): UseCase.SearchRecipes =
        UseCase.SearchRecipes(recipeWebService, recipeCache)

    @Singleton
    @Provides
    fun provideGetRecipe(
        recipeCache: RecipeCache,
    ): UseCase.GetRecipe =
        UseCase.GetRecipe(recipeCache)
}