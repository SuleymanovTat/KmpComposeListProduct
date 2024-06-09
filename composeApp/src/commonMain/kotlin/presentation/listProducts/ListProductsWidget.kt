package presentation.listProducts

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import data.models.Product
import kotlinx.datetime.Clock
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import presentation.ProductsViewModel

@Composable
fun ListProductsWidget(
    productsViewModel: ProductsViewModel,
    onClickItem: (Product) -> Unit,
) {
    val state = productsViewModel.products.collectAsState()
    val products = state.value
    print("products $products")
    Box(
        Modifier.fillMaxSize()
    ) {
        LazyColumn(contentPadding = PaddingValues(16.dp)) {
            TimeTextItem()
            SearchBarItem()
            item { Text("start os false products ${products.size}") }
            item {
                AsyncImage(
                    modifier = Modifier
                        .padding(16.dp)
                        .size(50.dp),
                    model = "https://fakestoreapi.com/img/71pWzhdJNwL._AC_UL640_QL65_ML3_.jpg",
//                model = product.image,
                    contentDescription = null
                )
            }
            ItemProduct(products, onClickItem)
        }
    }
}

private fun LazyListScope.ItemProduct(products: List<Product>, onClickItem: (Product) -> Unit) {
    items(products.size, key = {
        products[it].id.toString()
    }) {
        val product = products[it]
        println("image ${product.image}")
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.clickable {
            onClickItem(products[it])
        }) {
            AsyncImage(
                modifier = Modifier
                    .padding(16.dp)
                    .size(50.dp),
//                model = "https://fakestoreapi.com/img/71pWzhdJNwL._AC_UL640_QL65_ML3_.jpg",
                model = product.image,
                contentDescription = null
            )
            Column(verticalArrangement = Arrangement.Center) {
                Text(
                    text = "${product.title}",
                    style = TextStyle(
                        fontStyle = FontStyle.Italic,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                )
                Text(text = product.description.toString())
            }
        }
        HorizontalDivider(
            modifier = Modifier.padding(vertical = 8.dp)
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
private fun LazyListScope.SearchBarItem() {
    item {
        Column {
            SearchBar(
                modifier = Modifier.fillMaxWidth(),
                query = "",
                active = false,
                onActiveChange = {},
                onQueryChange = {},
                onSearch = {},
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Search"
                    )
                },
                placeholder = { Text("Search Products") }
            ) {}
            Spacer(modifier = Modifier.height(16.dp))
        }

    }
}

private fun LazyListScope.TimeTextItem() {
    item {
        val currentDate =
            Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault())
        Text("$currentDate")
    }
}