package it.gbale.apisports.apifootball;

import it.gbale.apisports.apifootball.model.exception.ApiError;
import org.apache.http.client.methods.HttpGet;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RequestFactoryTest {

    @Test
    void classCreationWithoutTokenNotPossibile() {
        assertThrows(ApiError.class, () -> new RequestFactory(null, true));
    }

    @Test
    void classCreationWithEmptyTokenNotPossibile() {
        assertThrows(ApiError.class, () -> new ApiFootball("", true));
    }

    @Test
    void makeRequestWithout() {
        assertThrows(ApiError.class, () -> new ApiFootball("", true));
    }

    @Test
    void activeEndpointIsAPISPORTS_URL() {
        RequestFactory factory = new RequestFactory("Test", true);
        assertEquals("https://v3.football.api-sports.io/",factory.getActiveEndpoint());
    }

    @Test
    void activeEndpointIsRAPID_API_URL() {
        RequestFactory factory = new RequestFactory("Test", false);
        assertEquals("https://api-football-v1.p.rapidapi.com/v3/",factory.getActiveEndpoint());
    }

    @Test
    void makeBuildRequestWithoutParametersSuccess() {
        RequestFactory factory = new RequestFactory("Test", true);
        HttpGet httpGet = factory.buildRequest("test");
        assertEquals(httpGet.getURI().toString(),"https://v3.football.api-sports.io/test");
    }

    @Test
    void makeBuildRequestWithoutParametersWithEmptyTerminalEndpoint() {
        RequestFactory factory = new RequestFactory("Test", true);
        HttpGet httpGet = factory.buildRequest("");
        assertEquals(httpGet.getURI().toString(),"https://v3.football.api-sports.io/");
    }

    @Test
    void makeRequestSuccess() {
        new RequestFactory("Test", true);
    }




}