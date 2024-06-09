import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import di.startKoinJvm
import presentation.App


fun main() = application {
    val koin = startKoinJvm().koin

    Window(
        onCloseRequest = ::exitApplication,
        title = "KotlinProjectCompose",
    ) {
        App()
    }
}