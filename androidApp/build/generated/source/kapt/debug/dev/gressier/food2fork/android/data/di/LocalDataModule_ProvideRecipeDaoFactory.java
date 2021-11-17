package dev.gressier.food2fork.android.data.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dev.gressier.food2fork.data.local.RecipeDatabase;
import dev.gressier.food2fork.data.local.daos.RecipeDao;
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
public final class LocalDataModule_ProvideRecipeDaoFactory implements Factory<RecipeDao> {
  private final Provider<RecipeDatabase> recipeDatabaseProvider;

  public LocalDataModule_ProvideRecipeDaoFactory(Provider<RecipeDatabase> recipeDatabaseProvider) {
    this.recipeDatabaseProvider = recipeDatabaseProvider;
  }

  @Override
  public RecipeDao get() {
    return provideRecipeDao(recipeDatabaseProvider.get());
  }

  public static LocalDataModule_ProvideRecipeDaoFactory create(
      Provider<RecipeDatabase> recipeDatabaseProvider) {
    return new LocalDataModule_ProvideRecipeDaoFactory(recipeDatabaseProvider);
  }

  public static RecipeDao provideRecipeDao(RecipeDatabase recipeDatabase) {
    return Preconditions.checkNotNullFromProvides(LocalDataModule.INSTANCE.provideRecipeDao(recipeDatabase));
  }
}
