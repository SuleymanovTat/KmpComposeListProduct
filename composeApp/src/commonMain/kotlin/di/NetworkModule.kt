package di

import io.ktor.client.HttpClient
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.dsl.module

//object MyClinet {
//    init {
//        HttpClient {
//            install(ContentNegotiation) {
//                json(Json {
//                    prettyPrint = true
//                    ignoreUnknownKeys = true
//                })
//            }
////            engine {
////                // this: Apache5EngineConfig
//////                followRedirects = true
//////                socketTimeout = 10_000
//////                connectTimeout = 10_000
//////                connectionRequestTimeout = 20_000
//////                customizeClient {
//////                    // this: HttpAsyncClientBuilder
//////                    setProxy(HttpHost("127.0.0.1", 8080))
//////                    // ...
//////                }
//////                customizeRequest {
//////                    // this: RequestConfig.Builder
//////                }
////            }
////            install(HttpTimeout) {
////            }
//        }
//    }
//}

fun networkModule() = module {
    single {
        HttpClient {
            install(ContentNegotiation) {
                json(Json {
                    prettyPrint = true
                    ignoreUnknownKeys = true
                })
            }
            install(HttpTimeout) {
            }
        }
    }
}