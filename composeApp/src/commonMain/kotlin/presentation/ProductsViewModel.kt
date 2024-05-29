package presentation

import data.models.Product
import data.repository.ProductRepository
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ProductsViewModel : ViewModel() {

    private val _products = MutableStateFlow<List<Product>>(emptyList())
    val products = _products.asStateFlow()
    private val repository = ProductRepository()

    init {
        viewModelScope.launch() {
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