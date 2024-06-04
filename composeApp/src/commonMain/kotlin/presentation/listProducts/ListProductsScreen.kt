package presentation.listProducts

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.koinScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import presentation.ProductsViewModel
import presentation.detailsProduct.DetailsProductScreen

class ListProductsScreen : Screen {

    @Composable
    override fun Content() {
//        println("ListProductsScreen")
//        val productsViewModel = koinScreenModel<ProductsViewModel>()
//        val navigator = LocalNavigator.currentOrThrow
//        ListProductsWidget(productsViewModel, onClickItem = {
//            navigator.push(DetailsProductScreen(it))
//        })
    }
}