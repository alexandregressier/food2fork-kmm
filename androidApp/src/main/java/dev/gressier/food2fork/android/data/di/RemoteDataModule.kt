package dev.gressier.food2fork.android.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.gressier.food2fork.data.remote.HttpClientFactory
import dev.gressier.food2fork.data.remote.webservices.RecipeWebService
import dev.gressier.food2fork.data.remote.webservices.RecipeWebServiceImpl
import io.ktor.client.*
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RemoteDataModule {

    @Singleton
    @Provides
    fun provideHttpClient(): HttpClient =
        HttpClientFactory().create()

    @Singleton
    @Provides
    fun provideRecipeWebService(httpClient: HttpClient): RecipeWebService =
        RecipeWebServiceImpl(httpClient)
}