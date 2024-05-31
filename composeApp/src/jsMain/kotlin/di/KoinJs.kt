package di


import org.koin.dsl.module


val jsModule = module {

}
fun startKoinJs() = initKoin(additionalModules = listOf(jsModule))