package dev.gressier.food2fork.android.presentation.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dev.gressier.food2fork.android.R

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController, startDestination = Screen.RecipeList.route) {
        composable(Screen.RecipeList.route) {
            Column {
                Text(stringResource(R.string.screenLabel_recipeList))
                Button({ navController.navigate(Screen.RecipeDetails.route) }) {
                    Text("Go to ${stringResource(R.string.screenLabel_recipeDetails)}")
                }
            }
        }
        composable(Screen.RecipeDetails.route) {
            Column {
                Text(stringResource(R.string.screenLabel_recipeDetails))
            }
        }
    }
}