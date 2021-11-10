package dev.gressier.food2fork.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import dagger.hilt.android.AndroidEntryPoint
import dev.gressier.composesandbox.ui.theme.Food2ForkTheme
import dev.gressier.food2fork.android.presentation.navigation.Navigation

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Food2ForkTheme {
                Navigation()
            }
        }
    }
}