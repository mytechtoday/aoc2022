package mytechtoday.aoc.util

import java.io.File
import java.net.*
import java.net.http.HttpClient
import java.time.Duration


object WebClient {
    val client: HttpClient
        get() {
            val session: String = getResourceAsString("APIKEY")
            CookieHandler.setDefault(CookieManager())
            val sessionCookie = HttpCookie("session", session)
            sessionCookie.path = "/"
            sessionCookie.version = 0
            try {
                (CookieHandler.getDefault() as CookieManager).cookieStore.add(
                    URI("https://adventofcode.com"),
                    sessionCookie
                )
            } catch (e: URISyntaxException) {
                throw IllegalStateException(e)
            }
            return HttpClient.newBuilder()
                .cookieHandler(CookieHandler.getDefault())
                .connectTimeout(Duration.ofSeconds(10))
                .build()
        }

    private fun getResourceAsString(fileName: String) =
        File("src/main/resources", "$fileName").readText()

}