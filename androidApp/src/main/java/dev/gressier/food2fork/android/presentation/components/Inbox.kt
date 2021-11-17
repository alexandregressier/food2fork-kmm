package dev.gressier.food2fork.android.presentation.components

import android.util.Log
import androidx.compose.runtime.Composable
import dev.gressier.food2fork.util.Queue
import dev.gressier.food2fork.presentation.model.VisibleMessage

private const val TAG = "INBOX"

@Composable
fun Inbox(
    messages: Queue<VisibleMessage>,
) {
    messages.front()?.let { message ->
        when (message) {
            is VisibleMessage.Dialog -> with(message) {
                Dialog(title, text, onDismiss)
            }
            is VisibleMessage.Log -> with(message) {
                Log.println(priority, TAG, text)
            }
        }
    }
}