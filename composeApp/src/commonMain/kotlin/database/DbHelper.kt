package database

import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import ru.suleymanovtat.AppDatabase

class DbHelper(val driverFactory: DriverFactory) {

    private var database: AppDatabase? = null

    private val mutex = Mutex()

    suspend fun <Result : Any> withDatabase(block: suspend (AppDatabase) -> Result): Result =
        mutex.withLock {
            if (database == null) {
                database = createDatabase(driverFactory)
            }
            return@withLock block(database!!)
        }

    private suspend fun createDatabase(driverFactory: DriverFactory): AppDatabase {
        return AppDatabase(driver = driverFactory.createDriver())

    }
}