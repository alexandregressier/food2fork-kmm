package dev.gressier.food2fork.android.presentation.recipelist.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import dev.gressier.food2fork.android.R
import dev.gressier.food2fork.presentation.recipelist.model.FoodCategory

@Composable
fun SearchTopBar(
    query: String = "",
    selectedFoodCategory: FoodCategory? = null,
    onQueryChange: (String) -> Unit = {},
    onQueryClear: () -> Unit = {},
    onFoodCategorySelect: (FoodCategory) -> Unit = {},
    onSearch: () -> Unit = {},
) {
    val keyboardController = LocalSoftwareKeyboardController.current

    Surface(
        Modifier.fillMaxWidth(),
        color = MaterialTheme.colors.secondary,
        elevation = 8.dp,
    ) {
        Column {
            TextField(
                query,
                onQueryChange,
                Modifier.fillMaxWidth(),
                textStyle = TextStyle(MaterialTheme.colors.onSurface),
                placeholder = { Text(stringResource(R.string.placeholder_searchRecipes)) },
                leadingIcon = { Icon(Icons.Filled.Search, stringResource(R.string.cd_icon_search)) },
                trailingIcon = {
                    if (query.isNotBlank()) {
                        IconButton(onQueryClear) {
                            Icon(Icons.Filled.Close, stringResource(R.string.cd_icon_clear))
                        }
                    }
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Search,
                ),
                keyboardActions = KeyboardActions(
                    onSearch = {
                        onSearch()
                        keyboardController?.hide()
                    }
                ),
                colors = TextFieldDefaults.textFieldColors(backgroundColor = MaterialTheme.colors.surface),
            )
            LazyRow(
                Modifier.padding(8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                items(FoodCategory.values()) { foodCategory ->
                    FoodCategoryChip(
                        foodCategory,
                        isSelected = foodCategory == selectedFoodCategory,
                        onSelect = { onFoodCategorySelect(foodCategory) },
                    )
                }
            }
        }
    }
}