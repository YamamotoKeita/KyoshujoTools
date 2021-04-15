package kyoshujotool

import okhttp3.*
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.toRequestBody

import java.net.URLEncoder
import java.nio.charset.Charset
import java.util.concurrent.TimeUnit

class HTTPClient {
    val client = OkHttpClient.Builder()
        .readTimeout(120, TimeUnit.SECONDS)
        .cookieJar(CookieJarImpl())
        .build()

    val userAgent = "MusashisakaiKyoshujo YoyakuAki Kakunin NoticeTool/1.0.0 (Yamamoto)"
    val charset = Charset.forName("Shift_JIS")

    fun get(url: String): String? {
        val request = Request.Builder()
            .url(url)
            .addHeader("User-Agent", userAgent)
            .build()

        val call = client.newCall(request)
        val response = call.execute()

        val bodyData = response.body?.bytes()
        if (bodyData != null) {
            return String(bodyData, charset)
        }

        return null
    }

    fun post(url: String, params: Map<String, String>): String? {
        val contentType = "application/x-www-form-urlencoded"
        val requestBuilder = Request.Builder()
            .url(url)
            .addHeader("User-Agent", userAgent)
            .addHeader("Origin", "https://www.e-license.jp")
            .addHeader("Content-Type", contentType)

        val postData = makePostData(params)
        val body = postData.toRequestBody(contentType.toMediaTypeOrNull())
        requestBuilder.post(body)

        val call = client.newCall(requestBuilder.build())
        val response = call.execute()

        val bodyData = response.body?.bytes()
        if (bodyData != null) {
            return String(bodyData, charset)
        }

        return null
    }

    private fun makePostData(postData: Map<String, String>): ByteArray {
        val text = postData.map {
            val key = URLEncoder.encode(it.key, charset)
            val value = URLEncoder.encode(it.value, charset)
            "$key=$value"
        }.joinToString("&")
        return text.toByteArray(charset)
    }

    class CookieJarImpl(val cookieStorage: OkHTTPCookieStorage = OkHTTPCookieStorage()): CookieJar {
        override fun saveFromResponse(url: HttpUrl, cookies: List<Cookie>) {
            cookieStorage.setCookies(url, cookies)
        }

        override fun loadForRequest(url: HttpUrl): MutableList<Cookie> {
            return cookieStorage.getCookies(url).toMutableList()
        }
    }
}