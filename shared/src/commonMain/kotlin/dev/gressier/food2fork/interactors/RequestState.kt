package dev.gressier.food2fork.interactors

sealed class RequestState<out T> {
    object Idle : RequestState<Nothing>()
    object Loading : RequestState<Nothing>()
    data class Success<T>(val data: T): RequestState<T>()
    object Empty: RequestState<Nothing>()
    data class Error(val throwable: Throwable): RequestState<Nothing>()
}