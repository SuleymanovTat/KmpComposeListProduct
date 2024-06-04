package database

import app.cash.sqldelight.async.coroutines.awaitAsList
import data.models.Product
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class Database(val dbHelper: DbHelper, val scope: CoroutineScope) {

    fun clearDatabase() {
        scope.launch {
            dbHelper.withDatabase { database ->
                database.appDatabaseQueries.removeAllProducts()
            }
        }
    }


    suspend fun getAllProducts(): List<Product> {
        var items: List<Product>
        val result = scope.async {
            dbHelper.withDatabase { database ->
                items = database.appDatabaseQueries.selectAllProducts(::mapProductSelecting)
                    .awaitAsList()
                items
            }
        }
        return result.await()
    }

    private fun mapProductSelecting(
        id: Long,
        title: String?,
        description: String?,
        category: String?,
        image: String?,
        price: Double,
    ): Product {

        return Product(
            id = id,
            price = price,
            category = category,
            description = description,
            title = title,
            image = image
        )
    }

    suspend fun createProducts(items: List<Product>) {
        val result = scope.async {
            dbHelper.withDatabase { database ->
                items.forEach {
                    insertProduct(it)
                }
            }
        }
    }

    private suspend fun insertProduct(item: Product) {
        scope.async {
            dbHelper.withDatabase { database ->
                database.appDatabaseQueries.insertProduct(
                    id = item.id,
                    title = item.title,
                    image = item.image,
                    price = item.price ?: 0.0,
                    category = item.category,
                    description = item.description.orEmpty(),
                )
            }
        }
    }
}