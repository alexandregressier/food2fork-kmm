package dev.gressier.food2fork.android.presentation.recipelist

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.gressier.food2fork.interactors.RequestState
import dev.gressier.food2fork.interactors.recipelist.SearchRecipes
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class RecipeListViewModel @Inject constructor(
    searchRecipes: SearchRecipes,
) : ViewModel() {

    init {
        // Search Recipes
        searchRecipes.execute(page = 1)
            .onEach {
                when (it) {
                    RequestState.Loading -> Log.d("RecipeListViewModel", "Loading...")
                    is RequestState.Success -> Log.d("RecipeListViewModel", "${it.data}")
                    is RequestState.Error -> Log.e("RecipeListViewModel", "${it.throwable.message}")
                }
            }.launchIn(viewModelScope)
    }
}