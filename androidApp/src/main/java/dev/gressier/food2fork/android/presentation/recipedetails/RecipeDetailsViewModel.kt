package dev.gressier.food2fork.android.presentation.recipedetails

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.gressier.food2fork.domain.model.RecipeId
import dev.gressier.food2fork.domain.usecase.UseCase
import dev.gressier.food2fork.domain.usecase.model.RequestState
import dev.gressier.food2fork.presentation.model.VisibleMessage
import dev.gressier.food2fork.presentation.recipedetails.RecipeDetailsEvent
import dev.gressier.food2fork.presentation.recipedetails.RecipeDetailsState
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class RecipeDetailsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val getRecipe: UseCase.GetRecipe,
) : ViewModel() {

    var state: RecipeDetailsState by mutableStateOf(RecipeDetailsState())

    init {
        savedStateHandle.get<RecipeId>("recipeId")?.let { recipeId ->
            emit(RecipeDetailsEvent.RecipeLoad(recipeId))
        }
    }

    fun emit(event: RecipeDetailsEvent) {
        when (event) {
            is RecipeDetailsEvent.RecipeLoad -> handleRecipeLoad(event.recipeId)
        }
    }

    private fun handleRecipeLoad(recipeId: RecipeId) {
        getRecipe(recipeId)
            .onEach {
                when (it) {
                    RequestState.Loading -> {
                        state = state.copy(isLoading = true)
                    }
                    is RequestState.Success -> {
                        state = state.copy(isLoading = false, recipe = it.data)
                    }
                    is RequestState.Error -> {
                        state = state.copy(isLoading = false, messages = state.messages.enqueue(
                            VisibleMessage.Dialog(
                                title = "Error",
                                text = it.throwable.message ?: "Unknown error",
                                onDismiss = {
                                    state = state.copy(messages = state.messages.dequeue())
                                },
                            )
                        ))
                    }
                }
            }.launchIn(viewModelScope)
    }
}