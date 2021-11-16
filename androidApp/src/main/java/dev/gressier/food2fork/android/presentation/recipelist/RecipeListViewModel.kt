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
        onEvent(RecipeListEvent.LoadRecipes)
    }

    fun onEvent(event: RecipeListEvent) {
        when (event) {
            RecipeListEvent.LoadRecipes -> loadRecipes()
            RecipeListEvent.NextPage -> nextPage()
        }
    }

    private fun loadRecipes() {
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

    private fun nextPage() {
        state = state.copy(page = state.page + 1)
        loadRecipes()
    }
}