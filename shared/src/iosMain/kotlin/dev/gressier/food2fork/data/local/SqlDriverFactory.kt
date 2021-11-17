package dev.gressier.food2fork.data.local

import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.drivers.native.NativeSqliteDriver

actual class SqlDriverFactory {

    actual fun create(): SqlDriver =
        NativeSqliteDriver(RecipeDatabase.Schema, "recipes.db")
}