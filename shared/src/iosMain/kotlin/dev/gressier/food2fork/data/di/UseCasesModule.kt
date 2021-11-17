package dev.gressier.food2fork.data.di

import dev.gressier.food2fork.data.di.LocalDataModule.recipeDao
import dev.gressier.food2fork.data.di.RemoteDataModule.recipeWebService
import dev.gressier.food2fork.domain.usecases.UseCase

object UseCasesModule {

    val searchRecipes: UseCase.SearchRecipes by lazy {
        UseCase.SearchRecipes(recipeWebService, recipeDao)
    }

    val getRecipe: UseCase.GetRecipe by lazy {
        UseCase.GetRecipe(recipeDao)
    }
}