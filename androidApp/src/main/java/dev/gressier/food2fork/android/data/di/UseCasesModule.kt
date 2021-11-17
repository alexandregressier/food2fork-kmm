package dev.gressier.food2fork.android.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.gressier.food2fork.data.local.daos.RecipeDao
import dev.gressier.food2fork.data.remote.webservices.RecipeWebService
import dev.gressier.food2fork.domain.usecases.UseCase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCasesModule {

    @Singleton
    @Provides
    fun provideSearchRecipes(
        recipeWebService: RecipeWebService,
        recipeDao: RecipeDao,
    ): UseCase.SearchRecipes =
        UseCase.SearchRecipes(recipeWebService, recipeDao)

    @Singleton
    @Provides
    fun provideGetRecipe(
        recipeDao: RecipeDao,
    ): UseCase.GetRecipe =
        UseCase.GetRecipe(recipeDao)
}