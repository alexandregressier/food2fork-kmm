package dev.gressier.food2fork.android.presentation.navigation

import androidx.annotation.StringRes
import dev.gressier.food2fork.android.R

sealed class Screen(val route: String, @StringRes val label: Int) {
    object RecipeList : Screen("recipeList", R.string.screenLabel_recipeList)
    object RecipeDetails : Screen("recipeDetails", R.string.screenLabel_recipeDetails)
}