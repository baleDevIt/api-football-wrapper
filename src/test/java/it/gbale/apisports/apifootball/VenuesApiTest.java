package it.gbale.apisports.apifootball;

import it.gbale.apisports.apifootball.model.core.ApiResponse;
import it.gbale.apisports.apifootball.model.entity.Venue;
import it.gbale.apisports.apifootball.model.exception.ApiError;
import it.gbale.apisports.apifootball.model.parameterEnum.VenuesParams;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class VenuesApiTest extends GenericTest<Venue> {

    private static ApiFootball apiFootball;

    @BeforeAll
    static void setup() {
        if (System.getenv("SERVICETOKEN") != null) {
            apiFootball = new ApiFootball(System.getenv("SERVICETOKEN"));
        }
    }

    @Test
    @EnabledIfEnvironmentVariable(named = "SERVICETOKEN", matches = "[A-Za-z0-9@]+", disabledReason = "Token api is null or not valid")
    void findVenue() {
        ApiResponse<Venue> venue = apiFootball.venuesApi().findVenue(Map.of(VenuesParams.ID, "556"));
        assertNotEquals(venue.getResponse().size(), 0);
        this.testEntity(venue.getResponse());
    }

    @Test
    @EnabledIfEnvironmentVariable(named = "SERVICETOKEN", matches = "[A-Za-z0-9@]+", disabledReason = "Token api is null or not valid")
    void findVenueById() {
        this.testEntity(apiFootball.venuesApi().findVenueById(556));
    }

    @Test
    @EnabledIfEnvironmentVariable(named = "SERVICETOKEN", matches = "[A-Za-z0-9@]+", disabledReason = "Token api is null or not valid")
    void findVenueByName() {
        this.testEntity(apiFootball.venuesApi().findVenueByName("Old Trafford"));
    }

    @Test
    @EnabledIfEnvironmentVariable(named = "SERVICETOKEN", matches = "[A-Za-z0-9@]+", disabledReason = "Token api is null or not valid")
    void findVenueByCity() {
        this.testEntity(apiFootball.venuesApi().findVenueByCity("Manchester"));
    }

    @Test
    @EnabledIfEnvironmentVariable(named = "SERVICETOKEN", matches = "[A-Za-z0-9@]+", disabledReason = "Token api is null or not valid")
    void findVenueByCountry() {
        this.testEntity(apiFootball.venuesApi().findVenueByCountry("England"));
    }

    @Test
    @EnabledIfEnvironmentVariable(named = "SERVICETOKEN", matches = "[A-Za-z0-9@]+", disabledReason = "Token api is null or not valid")
    void searchVenue() {
        this.testEntity(apiFootball.venuesApi().searchVenue("Old Trafford"));
    }

    void testEntity(List<Venue> venue){
        assertNotNull(venue);
        assertNotEquals(venue.size(), 0);
        Venue objTest = venue.stream().filter(venue1 -> venue1.getId() == 556).findFirst().orElseThrow(ApiError::new);
        assertEquals(556, objTest.getId());
        assertEquals("Old Trafford", objTest.getName());
        assertEquals("Sir Matt Busby Way", objTest.getAddress());
        assertEquals("Manchester", objTest.getCity());
        assertEquals("England", objTest.getCountry());
        assertEquals(76212, objTest.getCapacity());
        assertEquals("grass", objTest.getSurface());
        assertNotNull(objTest.getImage());
    }
}