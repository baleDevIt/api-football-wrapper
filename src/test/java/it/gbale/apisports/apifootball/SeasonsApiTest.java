package it.gbale.apisports.apifootball;

import it.gbale.apisports.apifootball.model.core.ApiResponse;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SeasonsApiTest {


    private static ApiFootball apiFootball;

    @BeforeAll
    static void setup() {
        if(System.getenv("SERVICETOKEN") != null){
            apiFootball = new ApiFootball(System.getenv("SERVICETOKEN"));
        }
    }

    @Test
    @EnabledIfEnvironmentVariable(named = "SERVICETOKEN", matches = "[A-Za-z0-9@]+", disabledReason = "Token api is null or not valid")
    void getAll_withRequestSuccess(){
        List<String> stringList =  apiFootball.seasonsApi().getAll_withRequest();
        assertNotNull(stringList);
        assertNotEquals(stringList.size(),0);
        stringList.forEach(value -> assertInstanceOf(String.class, value));
    }

    @Test
    @EnabledIfEnvironmentVariable(named = "SERVICETOKEN", matches = "[A-Za-z0-9@]+", disabledReason = "Token api is null or not valid")
    void getResponseRequestSuccess(){
        ApiResponse<String> response =  apiFootball.seasonsApi().getResponse();
        assertNotNull(response);
        assertNotEquals(response.getResponse().size(),0);
        assertEquals(response.getErrors().size(),0);
        response.getResponse().forEach(value -> assertInstanceOf(String.class, value));
    }


    @Test
    @EnabledIfEnvironmentVariable(named = "SERVICETOKEN", matches = "[A-Za-z0-9@]+", disabledReason = "Token api is null or not valid")
    void getAllRequestSuccess(){
        List<String> stringList =  apiFootball.seasonsApi().getAll();
        assertNotNull(stringList);
        assertTrue(stringList.size() > 0);
        stringList.forEach(value -> assertInstanceOf(String.class, value));
    }

    @Test
    @EnabledIfEnvironmentVariable(named = "SERVICETOKEN", matches = "[A-Za-z0-9@]+", disabledReason = "Token api is null or not valid")
    void getAllRequestListIsUnmodificable(){
        assertThrows(UnsupportedOperationException.class, () -> {
            List<String> stringList =  apiFootball.seasonsApi().getAll();
            stringList.add("Test");
        });
    }

    @Test
    @EnabledIfEnvironmentVariable(named = "SERVICETOKEN", matches = "[A-Za-z0-9@]+", disabledReason = "Token api is null or not valid")
    void getActualSeasonSuccess(){
        assertEquals(apiFootball.seasonsApi().getActualSeason(), "2023");
    }

}