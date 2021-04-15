package kyoshujotool

class AvailabilityStatus {
    val days = mutableListOf<DayStatus>()

    fun getNewAvailableTimes(lastStatus: AvailabilityStatus?): List<TimeFrame> {
        val result = mutableListOf<TimeFrame>()

        days.map { dayStatus ->
            val lastAvailableTimes = lastStatus
                ?.days
                ?.firstOrNull { it.date == dayStatus.date }
                ?.availableTimes

            val newTimes = dayStatus.availableTimes.filter {
                if (lastAvailableTimes != null) {
                    !lastAvailableTimes.contains(it)
                } else {
                    true
                }
            }

            val frames = newTimes.map { TimeFrame(dayStatus.date, it) }
            result.addAll(frames)
        }

        return result
    }

    fun add(date: String, availableTimes: List<String>) {
        days.add(DayStatus(date, availableTimes))
    }

    data class DayStatus(val date: String, val availableTimes: List<String>)
}