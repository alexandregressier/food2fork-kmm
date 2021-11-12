package dev.gressier.food2fork.android.presentation.recipedetails

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.gressier.food2fork.android.presentation.recipelist.RecipeId
import dev.gressier.food2fork.domain.model.Recipe
import dev.gressier.food2fork.domain.util.RequestState
import dev.gressier.food2fork.interactors.recipedetails.GetRecipe
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class RecipeDetailsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    getRecipe: GetRecipe,
) : ViewModel() {

    val recipe: MutableState<Recipe?> = mutableStateOf(null)

    init {
        // Get Recipe
        savedStateHandle.get<RecipeId>("recipeId")?.let { recipeId ->
            getRecipe.execute(recipeId)
                .onEach {
                    when (it) {
                        RequestState.Loading -> Log.d("RecipeDetailsViewModel", "Loading...")
                        is RequestState.Success -> {
                            recipe.value = it.data
                            Log.d("RecipeDetailsViewModel", "${it.data}")
                        }
                        is RequestState.Empty -> Log.e("RecipeDetailsViewModel", "No recipe for ID = $recipeId")
                        is RequestState.Error -> Log.e("RecipeDetailsViewModel", "${it.throwable.message}")
                    }
                }.launchIn(viewModelScope)
        }
    }
}