package dev.gressier.food2fork.data.local

import com.squareup.sqldelight.db.SqlDriver

expect class SqlDriverFactory {
    fun createDriver(): SqlDriver
}