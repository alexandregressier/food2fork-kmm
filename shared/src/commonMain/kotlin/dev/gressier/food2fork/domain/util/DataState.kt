package dev.gressier.food2fork.domain.util

data class DataState<T>(
    val message: String? = null,
    val data: T? = null,
    val isLoading: Boolean = false,
) {
    companion object {

        fun <T> data(message: String? = null, data: T? = null) =
            DataState(message, data)

        fun <T> error(message: String): DataState<T> =
            DataState(message)

        fun <T> loading(): DataState<T> =
            DataState(isLoading = true)
    }
}