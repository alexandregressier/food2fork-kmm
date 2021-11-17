package dev.gressier.food2fork.data.remote

import io.ktor.client.*

expect class KtorClientFactory {
    fun build(): HttpClient
}