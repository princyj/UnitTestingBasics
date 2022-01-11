import java.lang.RuntimeException
import com.beust.klaxon.*

data class Airport(
    @Json(name = "IATA") val code: String,
    @Json(name = "Name") val name: String,
    @Json(name = "Delay") val delay: Boolean) {
    companion object {
        fun sort(airports: List<Airport>) : List<Airport> {
            return airports.sortedBy { airport -> airport.name }
        }
        fun getAirportData(code: String) = Klaxon().parse<Airport>(fetchData(code)) as Airport

        fun fetchData(code: String): String {
            throw RuntimeException("Not Implemented Yet for $code")
        }
    }
}
