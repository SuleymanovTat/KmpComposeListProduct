import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import di.startKoinJvm
import presentation.App

val koin = startKoinJvm().koin

fun main() = application {
//    MyClinet.toString()
//    koin.toString()
    Window(
        onCloseRequest = ::exitApplication,
        title = "KotlinProjectCompose",
    ) {
        App()
    }
}