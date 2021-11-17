package dev.gressier.food2fork.android.presentation.recipedetails

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.gressier.food2fork.domain.model.RecipeId
import dev.gressier.food2fork.interactors.RequestState
import dev.gressier.food2fork.interactors.recipedetails.GetRecipe
import dev.gressier.food2fork.presentation.model.VisibleMessage
import dev.gressier.food2fork.presentation.recipedetails.RecipeDetailsEvent
import dev.gressier.food2fork.presentation.recipedetails.RecipeDetailsState
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class RecipeDetailsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val getRecipe: GetRecipe,
) : ViewModel() {

    var state: RecipeDetailsState by mutableStateOf(RecipeDetailsState())

    init {
        savedStateHandle.get<RecipeId>("recipeId")?.let { recipeId ->
            handleEvent(RecipeDetailsEvent.RecipeLoad(recipeId))
        }
    }

    fun handleEvent(event: RecipeDetailsEvent) {
        when (event) {
            is RecipeDetailsEvent.RecipeLoad -> handleRecipeLoad(event.recipeId)
        }
    }

    private fun handleRecipeLoad(recipeId: RecipeId) {
        getRecipe.execute(recipeId)
            .onEach {
                when (it) {
                    RequestState.Loading -> {
                        state = state.copy(isLoading = true)
                    }
                    is RequestState.Success -> {
                        state = state.copy(isLoading = false, recipe = it.data)
                    }
                    is RequestState.Error -> {
                        state = state.copy(isLoading = false)
                        state.messages.enqueue(
                            VisibleMessage.Dialog(
                                title = "Error",
                                text = it.throwable.message ?: "Unknown error",
                                onDismiss = {}, // TODO: implement onDismiss
                            )
                        )
                    }
                }
            }.launchIn(viewModelScope)
    }
}