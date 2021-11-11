package dev.gressier.food2fork.android.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import dev.gressier.food2fork.android.presentation.recipedetails.RecipeDetailsView
import dev.gressier.food2fork.android.presentation.recipedetails.RecipeDetailsViewModel
import dev.gressier.food2fork.android.presentation.recipelist.RecipeListView
import dev.gressier.food2fork.android.presentation.recipelist.RecipeListViewModel

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController, startDestination = Screen.RecipeList.route) {
        composable(Screen.RecipeList.route) {
            val viewModel = hiltViewModel<RecipeListViewModel>()
            RecipeListView(
                onRecipeSelect = { recipeId -> navController.navigate("${Screen.RecipeDetails.route}/$recipeId") },
            )
        }
        composable(
            route = "${Screen.RecipeDetails.route}/{recipeId}",
            arguments = listOf(navArgument("recipeId") { type = NavType.IntType })
        ) {
            val viewModel = hiltViewModel<RecipeDetailsViewModel>()
            RecipeDetailsView(
                recipe = viewModel.recipe.value,
            )
        }
    }
}