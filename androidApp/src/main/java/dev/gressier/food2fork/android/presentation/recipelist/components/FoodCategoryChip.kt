package dev.gressier.food2fork.android.presentation.recipelist.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import dev.gressier.food2fork.presentation.recipelist.FoodCategory

@Composable
fun FoodCategoryChip(
    foodCategory: FoodCategory,
    isSelected: Boolean = false,
    onSelect: (FoodCategory) -> Unit,
) {
    Surface(
        onClick = { onSelect(foodCategory) },
        shape = MaterialTheme.shapes.medium,
        color = if (isSelected) Color.LightGray else MaterialTheme.colors.primary,
    ) {
        Text(
            foodCategory.name,
            Modifier.padding(8.dp),
            Color.White,
            style = MaterialTheme.typography.body2,
        )
    }
}