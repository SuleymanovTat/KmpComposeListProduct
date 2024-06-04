package di


import database.DriverFactory
import org.koin.dsl.module


val jsModule = module {
    single { DriverFactory() }
}
fun startKoinJs() = initKoin(additionalModules = listOf(jsModule))