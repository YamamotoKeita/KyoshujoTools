package kyoshujotool

import org.jsoup.Jsoup
import org.jsoup.nodes.Element

class HTMLParser {
    fun parseAvailability(html: String): AvailabilityStatus {
        val document = Jsoup.parse(html)
        val tableList = document.select("table").toList()
        val calendarTable = tableList.firstOrNull { isCalendarTable(it) }
        if (calendarTable != null) {
            return parseCalendarTable(calendarTable)
        }
        throw IllegalStateException("HTMLから予約カレンダーが見つかりません。\n${html}")
    }

    private fun parseCalendarTable(table: Element): AvailabilityStatus {
        val trList = table.select("tr")
        val bodyTrList = trList.subList(1, trList.size)

        val dateList = bodyTrList
            .map { it.select("td").first().text() }

        val timeTdList = trList
            .first()
            .select("td")

        val timeList = timeTdList
            .subList(1, timeTdList.size)
            .map {
                val text = it.text()
                val items = text.split(" ")
                if (2 <= items.size) {
                    items[1]
                } else {
                    text
                }
            }

        val result = AvailabilityStatus()
        bodyTrList.forEachIndexed { dateIndex, tr ->
            val tds = tr.select("td")
            val availableTimes = mutableListOf<String>()
            tds.subList(1, tds.size).forEachIndexed { timeIndex, td ->
                val status = td.attr("class")
                val time = timeList[timeIndex]
                // status0: 空きなし、status1: 空きあり、status3: 自分が予約中
                if (status == "status1") {
                    availableTimes.add(time)
                }
            }

            result.add(dateList[dateIndex], availableTimes)
        }

        return result
    }

    private fun isCalendarTable(element: Element): Boolean {
        val firstTr = element.select("tr").firstOrNull()
        return firstTr?.attr("class") == "carender"
    }
}