package di

import data.datasource.ProductsLocalDataSource
import data.datasource.ProductsRemoteDataSource
import data.repository.ProductRepository
import org.koin.dsl.module
import presentation.ProductsViewModel

fun commonModule() = cacheModule() + networkModule() + module {

//    single {
//        ProductsRemoteDataSource(get())
//    }
//    single {
//        ProductsLocalDataSource(get())
//    }
//    single {
//        ProductRepository(get(), get())
//    }
//    single {
//        ProductsViewModel(get())
//    }
}