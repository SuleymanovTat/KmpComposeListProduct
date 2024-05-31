package data.repository

import data.models.Product
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlinx.coroutines.flow.flow

class ProductRepository(val httpClient: HttpClient) {

    suspend fun getProducts() =
        flow<List<Product>> {
            val response = httpClient.get("https://fakestoreapi.com/products")
            emit(response.body())
        }
}