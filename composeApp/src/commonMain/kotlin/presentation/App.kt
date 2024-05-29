package presentation

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import org.jetbrains.compose.ui.tooling.preview.Preview
import presentation.listProducts.ListProductsScreen


@Composable
@Preview
fun App() {
    MaterialTheme {
        Navigator(ListProductsScreen())
    }
}