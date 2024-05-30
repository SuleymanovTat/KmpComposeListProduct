package presentation

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.annotation.ExperimentalVoyagerApi
import cafe.adriel.voyager.jetpack.ProvideNavigatorLifecycleKMPSupport
import cafe.adriel.voyager.navigator.Navigator
import org.jetbrains.compose.ui.tooling.preview.Preview
import presentation.listProducts.ListProductsScreen


@OptIn(ExperimentalVoyagerApi::class)
@Composable
@Preview
fun App() {
    MaterialTheme {
        ProvideNavigatorLifecycleKMPSupport {
            Navigator(ListProductsScreen())
        }
    }
}