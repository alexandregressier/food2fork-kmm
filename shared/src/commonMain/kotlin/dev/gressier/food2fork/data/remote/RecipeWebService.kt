package dev.gressier.food2fork.data.remote

import dev.gressier.food2fork.data.remote.model.RecipeDto
import dev.gressier.food2fork.data.remote.model.RecipeSearchResponse
import dev.gressier.food2fork.domain.model.Recipe
import dev.gressier.food2fork.domain.model.RecipeId
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.http.*

interface RecipeWebService {
    suspend fun search(query: String, page: Int): List<Recipe>
    suspend fun get(id: RecipeId): Recipe
}

class RecipeWebServiceImpl(
    private val httpClient: HttpClient,
    private val baseUrl: String = BASE_URL,
) : RecipeWebService {

    override suspend fun search(query: String, page: Int): List<Recipe> =
        httpClient.get<RecipeSearchResponse> {
            url("$baseUrl/search?query=$query&page=$page")
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
        const val RECIPE_PAGINATION_PAGE_SIZE = 30
    }
}