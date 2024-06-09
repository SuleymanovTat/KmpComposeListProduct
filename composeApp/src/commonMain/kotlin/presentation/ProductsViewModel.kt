package presentation

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import data.models.Product
import data.repository.ProductRepository
import io.github.aakira.napier.Napier
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ProductsViewModel(val repository: ProductRepository) : ScreenModel {

    private val _products = MutableStateFlow<List<Product>>(emptyList())
    val products = _products.asStateFlow()

    init {
        Napier.e("my init")
        println("ProductsViewModel init")
        if (_products.value.isEmpty()) {
            println("ProductsViewModel launch ${_products.value.size}")
            screenModelScope.launch(Dispatchers.Default) {
//            screenModelScope.launch() {
                repository.getProducts()
                    .catch {
                        println("Error  ${it.message}")
                    }
                    .collect { products ->
                        println("_products  ${products.size}")
                        _products.update { it + products }
                    }
            }
        }
    }
}