package di

import data.repository.ProductRepository
import org.koin.dsl.module
import presentation.ProductsViewModel

fun commonModule() = networkModule() + module {

    single {
        ProductRepository(get())
    }
    single {
        ProductsViewModel(get())
    }
}