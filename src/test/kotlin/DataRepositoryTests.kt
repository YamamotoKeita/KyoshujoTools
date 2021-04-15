import kyoshujotool.AvailabilityStatus
import kyoshujotool.DataRepository
import org.junit.Test

class DataRepositoryTests {
    val repository = DataRepository()

    @Test
    fun readTest() {
        val status = repository.getLastStatus()

    }

    @Test
    fun writeTest() {
        val status = AvailabilityStatus()
        status.add("4/1", listOf("8:00", "9:00"))
        repository.save(status)
    }
}