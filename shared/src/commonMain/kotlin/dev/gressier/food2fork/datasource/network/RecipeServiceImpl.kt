package dev.gressier.food2fork.datasource.network

import dev.gressier.food2fork.datasource.network.model.RecipeDto
import dev.gressier.food2fork.datasource.network.model.RecipeSearchResponse
import dev.gressier.food2fork.domain.model.Recipe
import dev.gressier.food2fork.domain.model.RecipeId
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.http.*

class RecipeServiceImpl(
    private val httpClient: HttpClient,
    private val baseUrl: String = BASE_URL,
) : RecipeService {

    override suspend fun search(page: Int, query: String): List<Recipe> =
        httpClient.get<RecipeSearchResponse> {
            url("$baseUrl/search?page=$page&query=$query")
            header(HttpHeaders.Authorization, TOKEN)
        }
            .results
            .toRecipeList()

    override suspend fun get(id: RecipeId): Recipe =
        httpClient.get<RecipeDto> {
            url("$baseUrl/get?id=$id")
            header(HttpHeaders.Authorization, TOKEN)
        }
            .toRecipe()

    companion object {
        private const val BASE_URL = "https://food2fork.ca/api/recipe"
        private const val TOKEN = "Token 9c8b06d329136da358c2d00e76946b0111ce2c48"
    }
}