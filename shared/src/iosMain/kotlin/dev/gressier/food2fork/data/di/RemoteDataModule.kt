package dev.gressier.food2fork.data.di

import dev.gressier.food2fork.data.remote.HttpClientFactory
import dev.gressier.food2fork.data.remote.webservices.RecipeWebService
import dev.gressier.food2fork.data.remote.webservices.RecipeWebServiceImpl
import io.ktor.client.*

object RemoteDataModule {

    val httpClient: HttpClient by lazy {
        HttpClientFactory().create()
    }

    val recipeWebService: RecipeWebService by lazy {
        RecipeWebServiceImpl(httpClient)
    }
}