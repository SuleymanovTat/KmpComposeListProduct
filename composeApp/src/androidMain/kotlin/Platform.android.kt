import android.os.Build

class AndroidPlatform : Platform {
    override fun name(): String = "Android ${Build.VERSION.SDK_INT}"
}

actual fun getPlatform(): Platform = AndroidPlatform()