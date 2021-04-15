package kyoshujotool


fun main(args: Array<String>) {
    AvailabilityNoticeBatch().start()
}

class AvailabilityNoticeBatch {
    val webDataFetcher = WebDataFetcher()
    val dataRepository = DataRepository()
    val availabilityNotifier = AvailabilityNotifier()

    val loginId = "03744"
    val password = "19811202"

    fun start() {
        println("バッチ処理開始")
        val status = webDataFetcher.fetchAvailability(loginId, password)
        val lastStatus = dataRepository.getLastStatus()

        val newTimes = status.getNewAvailableTimes(lastStatus)
        if (newTimes.isNotEmpty()) {
            availabilityNotifier.notify(newTimes)
        } else {
            println("新規空き枠はありません")
        }

        dataRepository.save(status)
    }
}