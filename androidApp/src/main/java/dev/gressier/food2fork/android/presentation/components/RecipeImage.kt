package dev.gressier.food2fork.android.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter
import dev.gressier.food2fork.android.R
import io.ktor.http.*

@Composable
fun RecipeImage(
    url: Url,
    contentDescription: String,
) {
    val painter = rememberImagePainter(url.toString())
    val modifier = Modifier
        .fillMaxWidth()
        .height(dimensionResource(R.dimen.recipeImage_height))

    when (painter.state) {
        is ImagePainter.State.Loading -> Box(modifier.background(Color.White))
    }
    Image(
        painter,
        contentDescription,
        Modifier
            .fillMaxWidth()
            .height(dimensionResource(R.dimen.recipeImage_height)),
        contentScale = ContentScale.Crop,
    )
}