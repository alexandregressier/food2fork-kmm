package dev.gressier.food2fork.android.presentation.recipedetails

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.gressier.food2fork.android.presentation.recipelist.RecipeId
import dev.gressier.food2fork.datasource.network.RecipeService
import dev.gressier.food2fork.domain.model.Recipe
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecipeDetailsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    recipeService: RecipeService,
) : ViewModel() {

    val recipe: MutableState<Recipe?> = mutableStateOf(null)

    init {
        savedStateHandle.get<RecipeId>("recipeId")?.let { recipeId ->
            viewModelScope.launch {
                recipe.value = recipeService.get(recipeId)
            }
        }
    }
}