import platform.UIKit.UIDevice
import kotlin.random.Random

class IOSPlatform : Platform {
    override fun name(): String {
        val random = Random(100).nextInt() // generated random from 0 to 10 included

        return UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion +
                " Random " + random
            .toString()
    }
}

actual fun getPlatform(): Platform = IOSPlatform()