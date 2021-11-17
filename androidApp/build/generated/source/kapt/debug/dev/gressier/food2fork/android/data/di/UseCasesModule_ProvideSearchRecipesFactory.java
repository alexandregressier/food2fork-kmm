package dev.gressier.food2fork.android.data.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dev.gressier.food2fork.data.local.daos.RecipeDao;
import dev.gressier.food2fork.data.remote.webservices.RecipeWebService;
import dev.gressier.food2fork.domain.usecases.UseCase;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class UseCasesModule_ProvideSearchRecipesFactory implements Factory<UseCase.SearchRecipes> {
  private final Provider<RecipeWebService> recipeWebServiceProvider;

  private final Provider<RecipeDao> recipeDaoProvider;

  public UseCasesModule_ProvideSearchRecipesFactory(
      Provider<RecipeWebService> recipeWebServiceProvider, Provider<RecipeDao> recipeDaoProvider) {
    this.recipeWebServiceProvider = recipeWebServiceProvider;
    this.recipeDaoProvider = recipeDaoProvider;
  }

  @Override
  public UseCase.SearchRecipes get() {
    return provideSearchRecipes(recipeWebServiceProvider.get(), recipeDaoProvider.get());
  }

  public static UseCasesModule_ProvideSearchRecipesFactory create(
      Provider<RecipeWebService> recipeWebServiceProvider, Provider<RecipeDao> recipeDaoProvider) {
    return new UseCasesModule_ProvideSearchRecipesFactory(recipeWebServiceProvider, recipeDaoProvider);
  }

  public static UseCase.SearchRecipes provideSearchRecipes(RecipeWebService recipeWebService,
      RecipeDao recipeDao) {
    return Preconditions.checkNotNullFromProvides(UseCasesModule.INSTANCE.provideSearchRecipes(recipeWebService, recipeDao));
  }
}
