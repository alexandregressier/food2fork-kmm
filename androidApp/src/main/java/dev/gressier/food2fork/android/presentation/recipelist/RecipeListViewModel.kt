package dev.gressier.food2fork.android.presentation.recipelist

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.gressier.food2fork.interactors.RequestState
import dev.gressier.food2fork.interactors.recipelist.SearchRecipes
import dev.gressier.food2fork.presentation.recipelist.FoodCategory
import dev.gressier.food2fork.presentation.recipelist.RecipeListEvent
import dev.gressier.food2fork.presentation.recipelist.RecipeListState
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class RecipeListViewModel @Inject constructor(
    private val searchRecipes: SearchRecipes,
) : ViewModel() {

    var state: RecipeListState by mutableStateOf(RecipeListState())

    init {
        handleEvent(RecipeListEvent.RecipesLoad)
    }

    fun handleEvent(event: RecipeListEvent) {
        when (event) {
            RecipeListEvent.RecipesLoad -> handleRecipesLoad()
            RecipeListEvent.NextPage -> handleNextPage()
            is RecipeListEvent.QueryChange -> { handleQueryChange(event.query) }
            RecipeListEvent.QueryClear -> handleQueryClear()
            is RecipeListEvent.FoodCategorySelect -> { handleFoodCategorySelect(event.category) }
            RecipeListEvent.Search -> handleSearch()
        }
    }

    private fun handleRecipesLoad() {
        searchRecipes.execute(query = state.query, page = state.page)
            .onEach {
                when (it) {
                    RequestState.Loading -> {
                        state = state.copy(isLoading = true)
                    }
                    is RequestState.Success -> {
                        state = state.copy(isLoading = false)
                        state = state.copy(recipes = state.recipes + it.data)
                    }
                    is RequestState.Error -> {
                        state = state.copy(isLoading = false)
                        Log.e("RecipeListViewModel", "${it.throwable.message}")
                    }
                }
            }.launchIn(viewModelScope)
    }

    private fun handleNextPage() {
        state = state.copy(page = state.page + 1)
        handleRecipesLoad()
    }

    private fun handleQueryChange(query: String) {
        state = state.copy(query = query, selectedFoodCategory = null)
    }

    private fun handleQueryClear() {
        state = state.copy(query = "", selectedFoodCategory = null)
        handleSearch()
    }

    private fun handleFoodCategorySelect(category: FoodCategory) {
        state = state.copy(query = category.name, selectedFoodCategory = category)
        handleSearch()
    }

    private fun handleSearch() {
        state = state.copy(page =  1, recipes = listOf())
        handleRecipesLoad()
    }
}