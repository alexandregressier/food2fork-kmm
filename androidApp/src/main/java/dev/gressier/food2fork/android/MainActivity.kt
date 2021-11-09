package dev.gressier.food2fork.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import dev.gressier.composesandbox.ui.theme.Food2ForkTheme
import dev.gressier.food2fork.Greeting

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Food2ForkTheme {
                Box(Modifier.fillMaxSize(), Alignment.Center) {
                    Text(Greeting().greeting())
                }
            }
        }
    }
}