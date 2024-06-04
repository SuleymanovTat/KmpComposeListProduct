package data.repository

import data.datasource.ProductsLocalDataSource
import data.datasource.ProductsRemoteDataSource
import data.models.Product
import database.Database
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlinx.coroutines.flow.flow

class ProductRepository(
    val productsRemoteDataSource: ProductsRemoteDataSource,
    val productsLocalDataSource: ProductsLocalDataSource,
) {

    private suspend fun getAllProducts(forceReload: Boolean = false): List<Product> {
        val cachedItems = productsLocalDataSource.getAllProducts()
        return if (cachedItems.isNotEmpty() && !forceReload) {
            cachedItems
        } else {
            productsRemoteDataSource.getAllProducts().also {
                productsLocalDataSource.clearDb()
                productsLocalDataSource.saveProducts(it)
            }
        }
    }

    fun getProducts(forceReload: Boolean = false) = flow {
        emit(getAllProducts(forceReload))
    }
}