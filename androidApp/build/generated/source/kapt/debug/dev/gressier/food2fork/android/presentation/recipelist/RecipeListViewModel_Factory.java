package dev.gressier.food2fork.android.presentation.recipelist;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
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
public final class RecipeListViewModel_Factory implements Factory<RecipeListViewModel> {
  private final Provider<UseCase.SearchRecipes> searchRecipesProvider;

  public RecipeListViewModel_Factory(Provider<UseCase.SearchRecipes> searchRecipesProvider) {
    this.searchRecipesProvider = searchRecipesProvider;
  }

  @Override
  public RecipeListViewModel get() {
    return newInstance(searchRecipesProvider.get());
  }

  public static RecipeListViewModel_Factory create(
      Provider<UseCase.SearchRecipes> searchRecipesProvider) {
    return new RecipeListViewModel_Factory(searchRecipesProvider);
  }

  public static RecipeListViewModel newInstance(UseCase.SearchRecipes searchRecipes) {
    return new RecipeListViewModel(searchRecipes);
  }
}
