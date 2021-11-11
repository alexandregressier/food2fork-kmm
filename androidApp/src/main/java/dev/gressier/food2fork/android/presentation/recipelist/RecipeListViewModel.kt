package dev.gressier.food2fork.android.presentation.recipelist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.gressier.food2fork.interactors.recipelist.SearchRecipes
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class RecipeListViewModel @Inject constructor(
    searchRecipes: SearchRecipes,
) : ViewModel() {

    init {
        searchRecipes.execute(page = 1, query = "chicken")
            .onEach { dataState ->
                println("RecipeListViewModel: ${dataState.isLoading}")
                dataState.data?.let { recipes ->
                    println("RecipeListViewModel: ${recipes.count()}")
                }
                dataState.message?.let { message ->
                    println("RecipeListViewModel: $message")
                }
            }.launchIn(viewModelScope)
    }
}