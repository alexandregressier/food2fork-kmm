package dev.gressier.food2fork.util

open class Queue<out T>(val ts: List<T> = emptyList()) {

    fun front(): T? =
        ts.firstOrNull()

    fun enqueue(t: @UnsafeVariance T): Queue<T> =
        Queue(ts + t)

    fun dequeue(): Queue<T> =
        Queue(ts.drop(1))

    companion object {
        operator fun invoke(): Queue<Nothing> =
            EmptyQueue
    }
}

private object EmptyQueue : Queue<Nothing>()

fun <T> emptyQueue(): Queue<T> =
    EmptyQueue