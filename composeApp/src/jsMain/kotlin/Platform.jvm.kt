class JSPlatform : Platform {

    override fun name(): String {
        return "Compose for Web using Kotlin/JS"
    }
}

actual fun getPlatform(): Platform = JSPlatform()