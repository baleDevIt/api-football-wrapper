package it.gbale.apisports.apifootball;

import it.gbale.apisports.apifootball.model.core.ApiResponse;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.time.ZoneId;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TimezoneApiTest {

    private static ApiFootball apiFootball;

    @BeforeAll
    static void setup() {
        apiFootball = new ApiFootball(System.getenv("SERVICETOKEN"));
    }

    @Tag("ApiCall")
    @Test
    void getAllRequestSuccess(){
        List<String> stringList =  apiFootball.timezoneApi().getAll_withRequest();
        assertNotNull(stringList);
        assertTrue(stringList.size() > 0);
        stringList.forEach(value -> assertInstanceOf(String.class, value));
    }

    @Tag("ApiCall")
    @Test
    void getResponseRequestSuccess(){
        ApiResponse<String> stringList =  apiFootball.timezoneApi().getResponse();
        assertNotNull(stringList);
        assertNotEquals(stringList.getResponse().size(),0);
        assertEquals(stringList.getErrors().size(),0);
        stringList.getResponse().forEach(value -> assertInstanceOf(String.class, value));
    }

    @Tag("ApiCall")
    @Test
    void getAllTimezonesRequestSuccess(){
        List<ZoneId> zoneIds =  apiFootball.timezoneApi().getAllTimezone_withRequest();
        assertNotNull(zoneIds);
        assertTrue(zoneIds.size() > 0);
        zoneIds.forEach(value -> assertInstanceOf(ZoneId.class, value));
    }

    @Test
    void getAllZoneIdsRequestSuccess(){
        List<ZoneId> zoneIds =  apiFootball.timezoneApi().getAllZoneIds();
        assertNotNull(zoneIds);
        assertNotEquals(zoneIds.size(),0);
        zoneIds.forEach(value -> assertInstanceOf(ZoneId.class, value));
    }


}