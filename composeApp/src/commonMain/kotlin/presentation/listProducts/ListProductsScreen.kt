package presentation.listProducts

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.koinScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import io.github.aakira.napier.Napier
import presentation.ProductsViewModel
import presentation.detailsProduct.DetailsProductScreen

class ListProductsScreen : Screen {

    @Composable
    override fun Content() {
        println("ListProductsScreen start")
        Napier.e("my ListProductsScreen")
        val productsViewModel = koinScreenModel<ProductsViewModel>()
        val navigator = LocalNavigator.currentOrThrow
        ListProductsWidget(productsViewModel, onClickItem = {
            navigator.push(DetailsProductScreen(it))
        })
    }
}