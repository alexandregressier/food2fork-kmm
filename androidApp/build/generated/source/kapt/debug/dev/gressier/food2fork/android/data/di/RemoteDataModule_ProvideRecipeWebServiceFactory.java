package dev.gressier.food2fork.android.data.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dev.gressier.food2fork.data.remote.webservices.RecipeWebService;
import io.ktor.client.HttpClient;
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
public final class RemoteDataModule_ProvideRecipeWebServiceFactory implements Factory<RecipeWebService> {
  private final Provider<HttpClient> httpClientProvider;

  public RemoteDataModule_ProvideRecipeWebServiceFactory(Provider<HttpClient> httpClientProvider) {
    this.httpClientProvider = httpClientProvider;
  }

  @Override
  public RecipeWebService get() {
    return provideRecipeWebService(httpClientProvider.get());
  }

  public static RemoteDataModule_ProvideRecipeWebServiceFactory create(
      Provider<HttpClient> httpClientProvider) {
    return new RemoteDataModule_ProvideRecipeWebServiceFactory(httpClientProvider);
  }

  public static RecipeWebService provideRecipeWebService(HttpClient httpClient) {
    return Preconditions.checkNotNullFromProvides(RemoteDataModule.INSTANCE.provideRecipeWebService(httpClient));
  }
}
