package it.gbale.apisports.apifootball;

import it.gbale.apisports.apifootball.model.core.ApiResponse;
import it.gbale.apisports.apifootball.model.entity.League;
import it.gbale.apisports.apifootball.model.exception.ApiError;
import it.gbale.apisports.apifootball.model.exception.InvalidParamsException;
import it.gbale.apisports.apifootball.model.parameterEnum.LeaguesParams;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class LeaguesApiTest {

    private static ApiFootball apiFootball;

    @BeforeAll
    static void setup() {
        apiFootball = new ApiFootball(System.getenv("SERVICETOKEN"));
    }

    @Tag("ApiCall")
    @Test
    void getAllCurrentLeaguesSuccess(){
        List<League> leagues = apiFootball.leaguesApi().getAllCurrentLeagues();
        assertNotNull(leagues, "Response List of League is null");
        assertNotEquals(leagues.size(), 0, "Response List of League do not have element");
        leagues.forEach(element -> assertInstanceOf(League.class, element));
    }

    @Tag("ApiCall")
    @Test
    void getAllRequestSuccess(){
        List<League> leagues = apiFootball.leaguesApi().getAllLeagues();
        assertNotNull(leagues, "Response List of League is null");
        assertNotEquals(leagues.size(), 0, "Response List of League do not have element");
        leagues.forEach(element -> assertInstanceOf(League.class, element));
    }

    @Tag("ApiCall")
    @Test
    void getResponseSuccess(){
        ApiResponse<League> leagues = apiFootball.leaguesApi().getResponse();
        assertNotNull(leagues, "Response is null");
        assertEquals(leagues.getErrors().size(),0);
        assertNotEquals(leagues.getResponse().size(), 0, "Response List of League do not have element");
        assertEquals(leagues.getResults(), leagues.getResponse().size(), "The request is not inclusive of all elements. There are probably other pages");
        assertEquals(leagues.getPaging().getCurrent(), leagues.getPaging().getTotal(), "The Request have other pages - "+(leagues.getPaging().getTotal() - leagues.getPaging().getCurrent()));
        leagues.getResponse().forEach(element -> assertInstanceOf(League.class, element));
    }

    @Tag("ApiCall")
    @Test
    void findLeaguesRequestSuccess(){
        List<League> leagues;
        Map<LeaguesParams, String> paramsStringMap = new HashMap<>();
        paramsStringMap.put(LeaguesParams.CURRENT, "true");
        try {
            leagues = apiFootball.leaguesApi().findLeagues(paramsStringMap);
        } catch (InvalidParamsException e) {
            throw new RuntimeException(e);
        }
        assertNotNull(leagues, "Response List of League is null");
        assertNotEquals(leagues.size(), 0, "Response List of League do not have element");
        leagues.forEach(element -> assertInstanceOf(League.class, element));
    }

    @Tag("ApiCall")
    @Test
    void findCountriesRequestWithCodeParameterNotValid(){
        Map<LeaguesParams, String> paramsStringMap = new HashMap<>();
        paramsStringMap.put(LeaguesParams.CURRENT, "ciccio");
        assertThrows(ApiError.class, () -> apiFootball.leaguesApi().findLeagues(paramsStringMap));
    }

}