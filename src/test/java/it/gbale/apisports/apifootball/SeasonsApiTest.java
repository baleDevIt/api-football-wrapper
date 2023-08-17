package it.gbale.apisports.apifootball;

import it.gbale.apisports.apifootball.model.core.ApiResponse;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SeasonsApiTest {


    private static ApiFootball apiFootball;

    @BeforeAll
    static void setup() {
        apiFootball = new ApiFootball(System.getenv("SERVICETOKEN"));
    }

    @Tag("ApiCall")
    @Test
    void getAll_withRequestSuccess(){
        List<String> stringList =  apiFootball.seasonsApi().getAll_withRequest();
        assertNotNull(stringList);
        assertNotEquals(stringList.size(),0);
        stringList.forEach(value -> assertInstanceOf(String.class, value));
    }

    @Tag("ApiCall")
    @Test
    void getResponseRequestSuccess(){
        ApiResponse<String> response =  apiFootball.seasonsApi().getResponse();
        assertNotNull(response);
        assertNotEquals(response.getResponse().size(),0);
        assertEquals(response.getErrors().size(),0);
        response.getResponse().forEach(value -> assertInstanceOf(String.class, value));
    }


    @Test
    void getAllRequestSuccess(){
        List<String> stringList =  apiFootball.seasonsApi().getAll();
        assertNotNull(stringList);
        assertTrue(stringList.size() > 0);
        stringList.forEach(value -> assertInstanceOf(String.class, value));
    }

    @Test
    void getAllRequestListIsUnmodificable(){
        assertThrows(UnsupportedOperationException.class, () -> {
            List<String> stringList =  apiFootball.seasonsApi().getAll();
            stringList.add("Test");
        });
    }

    @Test
    void getActualSeasonSuccess(){
        assertEquals(apiFootball.seasonsApi().getActualSeason(), "2023");
    }

}