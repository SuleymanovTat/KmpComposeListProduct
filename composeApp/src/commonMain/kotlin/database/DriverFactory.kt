package database

import app.cash.sqldelight.db.SqlDriver
import ru.suleymanovtat.AppDatabase


expect class DriverFactory {

    suspend fun createDriver(): SqlDriver
}

