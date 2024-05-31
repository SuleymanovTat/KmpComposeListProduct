import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.CanvasBasedWindow
import di.startKoinJs
import org.jetbrains.skiko.wasm.onWasmReady
import presentation.App

val koin = startKoinJs().koin

@OptIn(ExperimentalComposeUiApi::class)
fun main() {

    onWasmReady {
        CanvasBasedWindow("KotlinProjectCompose") {
            koin.toString()
            App()
        }
    }
}
