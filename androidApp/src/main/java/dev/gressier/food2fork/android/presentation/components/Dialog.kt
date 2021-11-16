package dev.gressier.food2fork.android.presentation.components

import androidx.compose.material.AlertDialog
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import dev.gressier.food2fork.android.R

@Composable
fun Dialog(
    title: String,
    text: String? = null,
    dismissButtonText: String = stringResource(R.string.dialog_button_ok),
    onDismiss: () -> Unit = {},
) {
    AlertDialog(
        title = { Text(title) },
        text = { text?.let { text -> Text(text) } },
        confirmButton = {
            TextButton(onDismiss) {
                Text(
                    dismissButtonText,
                    color = MaterialTheme.colors.primary,
                    style = MaterialTheme.typography.button,
                )
            }
        },
        onDismissRequest = onDismiss,
    )
}