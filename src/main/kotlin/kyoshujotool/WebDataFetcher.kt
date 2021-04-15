package kyoshujotool

class WebDataFetcher {
    val httpClient = HTTPClient()
    val firstURL = "https://www.e-license.jp/el25/?abc=zA5IKlz%2B5to%2BbrGQYS%2B1OA%3D%3D"
    val loginURL = "https://www.e-license.jp/el25/pc/p01a.action"

    fun fetchAvailability(loginId: String, password: String): AvailabilityStatus {
        println("ログイン画面取得 開始")
        httpClient.get(firstURL)
        println("ログイン画面取得 完了")

        val postData = mapOf(
            "b.studentId" to loginId,
            "b.password" to password,
            "method:doLogin" to "ログイン",
            "b.wordsStudentNo" to "教習生番号",
            "b.processCd" to "",
            "b.kamokuCd" to "",
            "b.schoolCd" to "zA5IKlz%2B5to%2BbrGQYS%2B1OA%3D%3D",
            "index" to "",
            "server" to "qar004",
        )

        println("ログイン 開始")
        val html = httpClient.post(loginURL, postData)
        println("ログイン 完了")

        return HTMLParser().parseAvailability(html!!)
    }

}
