package dev.gressier.food2fork.data.local

import android.content.Context
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver

actual class SqlDriverFactory(private val context: Context) {

    actual fun create(): SqlDriver =
        AndroidSqliteDriver(RecipeDatabase.Schema, context, "recipes.db")
}