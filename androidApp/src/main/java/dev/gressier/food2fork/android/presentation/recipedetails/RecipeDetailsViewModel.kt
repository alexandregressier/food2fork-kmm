package dev.gressier.food2fork.android.presentation.recipedetails

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.gressier.food2fork.android.presentation.recipelist.RecipeId
import javax.inject.Inject

@HiltViewModel
class RecipeDetailsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
) : ViewModel() {

    val recipeId: MutableState<RecipeId?> = mutableStateOf(null)

    init {
        savedStateHandle.get<RecipeId>("recipeId")?.let { recipeId.value = it }
    }
}