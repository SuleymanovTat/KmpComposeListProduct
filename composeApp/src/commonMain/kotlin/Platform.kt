interface Platform {
    fun name(): String
}

expect fun getPlatform(): Platform