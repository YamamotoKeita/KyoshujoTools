package kyoshujotool

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import java.io.File


class DataRepository {
    val file = File("kyoshujo-status.json")

    fun getLastStatus(): AvailabilityStatus? {
        if (!file.exists()) {
            return null
        }
        val json = file.readText(Charsets.UTF_8)
        return Gson().fromJson(json, AvailabilityStatus::class.java)
    }

    fun save(status: AvailabilityStatus) {
        val json = toJSON(status)
        file.writeText(json, Charsets.UTF_8)
    }

    fun toJSON(status: AvailabilityStatus): String {
        return GsonBuilder().setPrettyPrinting().create()
            .toJson(status)
    }
}
