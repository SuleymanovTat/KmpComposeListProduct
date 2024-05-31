package di


import org.koin.dsl.module

val jvmModule = module {

}
fun startKoinJvm() = initKoin(additionalModules = listOf(jvmModule))