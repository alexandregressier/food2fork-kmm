package dev.gressier.food2fork.android.presentation.components

import androidx.compose.runtime.Composable
import com.soywiz.kds.Queue

@Composable
fun ErrorQueueDialogs(
    errorQueue: Queue<Throwable>,
) {
    errorQueue.peek()?.let { throwable ->
        Dialog(title = "Error", text = throwable.message)
    }
}