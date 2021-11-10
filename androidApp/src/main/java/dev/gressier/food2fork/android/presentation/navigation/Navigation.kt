package dev.gressier.food2fork.android.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import dev.gressier.food2fork.android.presentation.recipedetails.RecipeDetailsScreen
import dev.gressier.food2fork.android.presentation.recipelist.RecipeListScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController, startDestination = Screen.RecipeList.route) {
        composable(Screen.RecipeList.route) {
            RecipeListScreen(
                onRecipeSelect = { recipeId ->
                    navController.navigate("${Screen.RecipeDetails.route}/$recipeId")
                },
            )
        }
        composable(
            route = "${Screen.RecipeDetails.route}/{recipeId}",
            arguments = listOf(navArgument("recipeId") { type = NavType.IntType })
        ) { navBackStackEntry ->
            RecipeDetailsScreen(recipeId = navBackStackEntry.arguments?.getInt("recipeId"))
        }
    }
}