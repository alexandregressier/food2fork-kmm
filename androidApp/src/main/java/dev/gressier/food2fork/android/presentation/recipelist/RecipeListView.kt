package dev.gressier.food2fork.android.presentation.recipelist

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import dev.gressier.food2fork.android.presentation.components.CircularIndeterminateProgressBar
import dev.gressier.food2fork.android.presentation.components.Inbox
import dev.gressier.food2fork.android.presentation.recipelist.components.SearchTopBar
import dev.gressier.food2fork.android.presentation.theme.Gray1
import dev.gressier.food2fork.domain.model.RecipeId
import dev.gressier.food2fork.presentation.recipelist.RecipeListEvent
import dev.gressier.food2fork.presentation.recipelist.RecipeListState

@Composable
fun RecipeListView(
    state: RecipeListState,
    emit: (RecipeListEvent) -> Unit,
    navigateToRecipeDetails: (RecipeId) -> Unit = {},
) {
    Box(
        Modifier
            .fillMaxSize()
            .background(color = Gray1),
    ) {
        state.apply {
            Inbox(messages)
            Scaffold(
                topBar = {
                    SearchTopBar(
                        query,
                        selectedFoodCategory = selectedFoodCategory,
                        onQueryChange = { query -> emit(RecipeListEvent.QueryChange(query)) },
                        onQueryClear = { emit(RecipeListEvent.QueryClear) },
                        onFoodCategorySelect = { foodCategory -> emit(RecipeListEvent.FoodCategorySelect(foodCategory)) },
                        onSearch = { emit(RecipeListEvent.Search) },
                    )
                },
            ) {
                RecipeList(
                    isLoading,
                    recipes,
                    page,
                    onNextPage = { emit(RecipeListEvent.NextPage) },
                    onRecipeListItemClick = navigateToRecipeDetails,
                )
                if (isLoading) {
                    CircularIndeterminateProgressBar(isDisplayed = isLoading)
                }
            }
        }
    }
}