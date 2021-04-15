package kyoshujotool

import com.google.gson.Gson
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody

class AvailabilityNotifier {
    val client = OkHttpClient()

    val slackPostURL = "https://hooks.slack.com/services/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"

    fun notify(newTimes: List<TimeFrame>): String {
        val contentType = "application/json"
        val requestBuilder = Request.Builder()
            .url(slackPostURL)
            .addHeader("Content-Type", contentType)

        val message = makeNoticeMessage(newTimes)
        println(message)
        val postData = makePostData(message)
        val body = postData.toRequestBody(contentType.toMediaTypeOrNull())
        requestBuilder.post(body)

        val call = client.newCall(requestBuilder.build())
        val response = call.execute()

        val bodyData = response.body?.bytes()
        if (bodyData != null) {
            val result = String(bodyData, Charsets.UTF_8)
            println("メッセージ送信結果: $result")
        }
        return message
    }

    private fun makePostData(message: String): ByteArray {
        val data = mapOf("text" to message)
        val json = Gson().toJson(data)
        return json.toByteArray(Charsets.UTF_8)
    }

    fun makeNoticeMessage(newTimes: List<TimeFrame>): String {
        var message = "以下の時間に技能予約の空きが出ました。\n"
        message += newTimes.joinToString("\n") { "■ ${it.date} ${it.time}" }

        return message
    }
}
