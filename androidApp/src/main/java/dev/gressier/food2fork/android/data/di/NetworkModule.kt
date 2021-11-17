package dev.gressier.food2fork.android.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.gressier.food2fork.data.remote.KtorClientFactory
import dev.gressier.food2fork.data.remote.RecipeWebService
import dev.gressier.food2fork.data.remote.RecipeWebServiceImpl
import io.ktor.client.*
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideHttpClient(): HttpClient =
        KtorClientFactory().build()

    @Singleton
    @Provides
    fun provideRecipeWebService(httpClient: HttpClient): RecipeWebService =
        RecipeWebServiceImpl(httpClient)
}