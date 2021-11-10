package dev.gressier.food2fork.datasource.network

import io.ktor.client.*

expect class KtorClientFactory {
    fun build(): HttpClient
}