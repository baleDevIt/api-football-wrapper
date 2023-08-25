package it.gbale.apisports.apifootball;

import it.gbale.apisports.apifootball.model.core.ApiResponse;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;

import java.time.ZoneId;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TimezoneApiTest {

    private static ApiFootball apiFootball;

    @BeforeAll
    static void setup() {
        if(System.getenv("SERVICETOKEN") != null){
            apiFootball = new ApiFootball(System.getenv("SERVICETOKEN"));
        }
    }

    @Test
    @EnabledIfEnvironmentVariable(named = "SERVICETOKEN", matches = "[A-Za-z0-9@]+", disabledReason = "Token api is null or not valid")
    void getAllRequestSuccess(){
        List<String> stringList =  apiFootball.timezoneApi().getAll_withRequest();
        assertNotNull(stringList);
        assertTrue(stringList.size() > 0);
        stringList.forEach(value -> assertInstanceOf(String.class, value));
    }

    @Test
    @EnabledIfEnvironmentVariable(named = "SERVICETOKEN", matches = "[A-Za-z0-9@]+", disabledReason = "Token api is null or not valid")
    void getResponseRequestSuccess(){
        ApiResponse<String> stringList =  apiFootball.timezoneApi().getResponse();
        assertNotNull(stringList);
        assertNotEquals(stringList.getResponse().size(),0);
        assertEquals(stringList.getErrors().size(),0);
        stringList.getResponse().forEach(value -> assertInstanceOf(String.class, value));
    }

    @Test
    @EnabledIfEnvironmentVariable(named = "SERVICETOKEN", matches = "[A-Za-z0-9@]+", disabledReason = "Token api is null or not valid")
    void getAllTimezonesRequestSuccess(){
        List<ZoneId> zoneIds =  apiFootball.timezoneApi().getAllTimezone_withRequest();
        assertNotNull(zoneIds);
        assertTrue(zoneIds.size() > 0);
        zoneIds.forEach(value -> assertInstanceOf(ZoneId.class, value));
    }

    @Test
    @EnabledIfEnvironmentVariable(named = "SERVICETOKEN", matches = "[A-Za-z0-9@]+", disabledReason = "Token api is null or not valid")
    void getAllZoneIdsRequestSuccess(){
        List<ZoneId> zoneIds =  apiFootball.timezoneApi().getAllZoneIds();
        assertNotNull(zoneIds);
        assertNotEquals(zoneIds.size(),0);
        zoneIds.forEach(value -> assertInstanceOf(ZoneId.class, value));
    }


}