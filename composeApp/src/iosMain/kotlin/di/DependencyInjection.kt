package di

import database.DriverFactory
import org.koin.dsl.module

val iosModule = module {
//    single { LifecycleRegistry() }
//    single<ComponentContext> { DefaultComponentContext(lifecycle = get<LifecycleRegistry>()) }
//    single { DriverFactory() }
}


fun initKoinIOS() = initKoin(additionalModules = listOf(iosModule))