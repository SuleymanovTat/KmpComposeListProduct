package presentation.listProducts

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import presentation.ProductsViewModel
import presentation.detailsProduct.DetailsProductScreen

class ListProductsScreen : Screen {

    @Composable
    override fun Content() {
        println("ListProductsScreen")
        val homeViewModel = rememberScreenModel { ProductsViewModel() }
        val navigator = LocalNavigator.currentOrThrow
        ListProductsWidget(homeViewModel, onClickItem = {
            navigator.push(DetailsProductScreen(it))
        })
    }
}