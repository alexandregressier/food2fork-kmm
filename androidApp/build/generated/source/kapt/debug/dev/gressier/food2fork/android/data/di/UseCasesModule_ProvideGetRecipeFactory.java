package dev.gressier.food2fork.android.data.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dev.gressier.food2fork.data.local.daos.RecipeDao;
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
public final class UseCasesModule_ProvideGetRecipeFactory implements Factory<UseCase.GetRecipe> {
  private final Provider<RecipeDao> recipeDaoProvider;

  public UseCasesModule_ProvideGetRecipeFactory(Provider<RecipeDao> recipeDaoProvider) {
    this.recipeDaoProvider = recipeDaoProvider;
  }

  @Override
  public UseCase.GetRecipe get() {
    return provideGetRecipe(recipeDaoProvider.get());
  }

  public static UseCasesModule_ProvideGetRecipeFactory create(
      Provider<RecipeDao> recipeDaoProvider) {
    return new UseCasesModule_ProvideGetRecipeFactory(recipeDaoProvider);
  }

  public static UseCase.GetRecipe provideGetRecipe(RecipeDao recipeDao) {
    return Preconditions.checkNotNullFromProvides(UseCasesModule.INSTANCE.provideGetRecipe(recipeDao));
  }
}
