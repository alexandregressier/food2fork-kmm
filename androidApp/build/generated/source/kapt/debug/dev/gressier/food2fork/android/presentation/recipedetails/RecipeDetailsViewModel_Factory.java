package dev.gressier.food2fork.android.presentation.recipedetails;

import androidx.lifecycle.SavedStateHandle;
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
public final class RecipeDetailsViewModel_Factory implements Factory<RecipeDetailsViewModel> {
  private final Provider<SavedStateHandle> savedStateHandleProvider;

  private final Provider<UseCase.GetRecipe> getRecipeProvider;

  public RecipeDetailsViewModel_Factory(Provider<SavedStateHandle> savedStateHandleProvider,
      Provider<UseCase.GetRecipe> getRecipeProvider) {
    this.savedStateHandleProvider = savedStateHandleProvider;
    this.getRecipeProvider = getRecipeProvider;
  }

  @Override
  public RecipeDetailsViewModel get() {
    return newInstance(savedStateHandleProvider.get(), getRecipeProvider.get());
  }

  public static RecipeDetailsViewModel_Factory create(
      Provider<SavedStateHandle> savedStateHandleProvider,
      Provider<UseCase.GetRecipe> getRecipeProvider) {
    return new RecipeDetailsViewModel_Factory(savedStateHandleProvider, getRecipeProvider);
  }

  public static RecipeDetailsViewModel newInstance(SavedStateHandle savedStateHandle,
      UseCase.GetRecipe getRecipe) {
    return new RecipeDetailsViewModel(savedStateHandle, getRecipe);
  }
}
