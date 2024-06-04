package di


import database.DriverFactory
import org.koin.dsl.module

val jvmModule = module {
    single { DriverFactory() }
}
fun startKoinJvm() = initKoin(additionalModules = listOf(jvmModule))