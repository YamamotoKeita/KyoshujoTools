package kyoshujotool

import okhttp3.Cookie
import okhttp3.HttpUrl

class OkHTTPCookieStorage {

    private var cookieMap: MutableMap<String, MutableList<Cookie>> = mutableMapOf()

    @Synchronized
    fun setCookies(url: HttpUrl, cookies: List<Cookie>) {
        val targetList = cookieMap[url.host] ?: mutableListOf()
        cookies.forEach { cookie ->
            targetList.removeAll { it.keyEquals(cookie) }
        }
        targetList.addAll(cookies)
        cookieMap[url.host] = targetList
    }

    @Synchronized
    fun getCookies(url: HttpUrl): List<Cookie> {
        val host = url.host
        removeExpiredCookies(host)

        val path = url.encodedPath
        val targetList = cookieMap[host] ?: return mutableListOf()

        return targetList.filter {
            path.startsWith(it.path) && it.domain == host
        }
    }

    @Suppress("MemberVisibilityCanBePrivate")
    private fun removeExpiredCookies(host: String) {
        val targetList = cookieMap[host] ?: return
        targetList.removeAll { it.hasExpired }
        cookieMap[host] = targetList
    }

    @Synchronized
    fun clear() {
        cookieMap.clear()
    }

}

val Cookie.hasExpired: Boolean
    get() {
        return expiresAt < System.currentTimeMillis()
    }

fun Cookie.keyEquals(other: Any?): Boolean {
    if (other !is Cookie) return false
    val that = other as Cookie?
    return that?.name == name && that?.domain == domain && that?.path == path
}
