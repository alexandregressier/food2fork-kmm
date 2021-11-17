package dev.gressier.food2fork.presentation.model

sealed class VisibleMessage(
    open val text: String,
) {
    data class Dialog(
        val title: String = "",
        override val text: String,
        val onDismiss: () -> Unit,
        val dismissButtonText: String = "OK",
    ) : VisibleMessage(text)

    data class Log(
        override val text: String,
        val priority: Int = 1,
    ) : VisibleMessage(text)
}