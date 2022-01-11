
import io.mockk.clearAllMocks
import io.mockk.every
import io.mockk.mockkObject
import io.mockk.verify
import org.junit.jupiter.api.Test
import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.assertEquals

class AirportTest {
    private val iah = Airport("IAH", "Houston", true)
    private val iad = Airport("IAD", "Dulles", false)

    @BeforeTest
    fun setUp() {
        mockkObject(Airport)
    }

    @Test
    fun `createAirport`() {
        assertEquals("IAH", iah.code)
        assertEquals("IAD", iad.code)
    }

    @Test
    fun `GIVEN empty list WHEN the list is sorted THEN should return an empty list`() {
        assertEquals(listOf(), Airport.sort(listOf()))
    }

    @Test
    fun `GIVEN a list WHEN the list is sorted THEN should return airports in sorted order`() {
        assertEquals(listOf(iad, iah), Airport.sort(listOf(iad, iah)))
    }

    @Test
    fun `GIVEN Airport WHEN getAirportData is called THEN fetchData is invoked`() {
        every { Airport.fetchData("IAD") } returns
                """{"IATA":"IAD", "Name": "Dulles", "Delay": false}"""
        Airport.getAirportData("IAD")
        verify { Airport.fetchData("IAD") }
    }

    @Test
    fun `GIVEN Airport WHEN getAirportData is called THEN Airport object is extracted out of the JSON`() {
        every { Airport.fetchData("IAD") } returns
                """{"IATA":"IAD", "Name": "Dulles", "Delay": false}"""
        assertEquals(iad, Airport.getAirportData("IAD"))
        verify { Airport.fetchData("IAD") }
    }

    @AfterTest
    fun afterTest() {
        clearAllMocks()
    }

}