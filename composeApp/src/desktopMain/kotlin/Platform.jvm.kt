class JVMPlatform : Platform {
    override fun name(): String = "Java ${System.getProperty("java.version")}"
}

actual fun getPlatform(): Platform = JVMPlatform()