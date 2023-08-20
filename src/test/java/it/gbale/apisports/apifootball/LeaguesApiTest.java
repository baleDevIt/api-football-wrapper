package it.gbale.apisports.apifootball;

import it.gbale.apisports.apifootball.model.entity.League;
import it.gbale.apisports.apifootball.model.entity.Season;
import it.gbale.apisports.apifootball.model.entity.Team;
import it.gbale.apisports.apifootball.model.exception.ApiError;
import it.gbale.apisports.apifootball.model.parameterEnum.LeaguesParams;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.time.Year;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class LeaguesApiTest extends GenericTest<League> {

    private static ApiFootball apiFootball;
    private static Team team;

    @BeforeAll
    static void setup() {
        apiFootball = new ApiFootball(System.getenv("SERVICETOKEN"));
        team = new Team();
        team.setId(33);
        team.setName("Manchester United");
        team.setCode("MUN");
    }
    @Tag("ApiCall")
    @Test
    void getAllCurrentLeaguesSuccess(){
        testListObjSuccess(apiFootball.leaguesApi().getAllCurrentLeagues(), League.class) ;
    }

    @Tag("ApiCall")
    @Test
    void getAllRequestSuccess(){
        testListObjSuccess(apiFootball.leaguesApi().getAllLeagues(), League.class);
    }

    @Tag("ApiCall")
    @Test
    void getResponseSuccess(){
        testResponseObjSuccess(apiFootball.leaguesApi().getResponse(),League.class);

    }

    @Tag("ApiCall")
    @Test
    void findLeaguesRequestSuccess(){
        Map<LeaguesParams, String> paramsStringMap = new HashMap<>();
        paramsStringMap.put(LeaguesParams.CURRENT, "true");
        List<League> leagues = apiFootball.leaguesApi().findLeagues(paramsStringMap);
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

    @Test
    void findLeaguesAtSeasonRequestWithNullYearValue(){
        assertThrows(IllegalArgumentException.class, () -> apiFootball.leaguesApi().findLeaguesAtSeason((Year) null));
    }

    @Test
    void findLeaguesAtSeasonRequestWithNullSeasonValue(){
        assertThrows(IllegalArgumentException.class, () -> apiFootball.leaguesApi().findLeaguesAtSeason((Season) null));
    }

    @Test
    void findLeaguesAtSeasonRequestActualYear(){
        testListObjSuccess(apiFootball.leaguesApi().findLeaguesAtSeason(Year.now()), League.class);
    }

    @Test
    void findLeaguesRequest(){
        testListObjSuccess(apiFootball.leaguesApi().searchLeagues("Serie A"), League.class);
    }

    @Test
    void findLeaguesRequestWithInexistentLeagues(){
        testEmptyListObj(apiFootball.leaguesApi().searchLeagues("LaMiaStagionePreferita"), League.class);
    }

    @Test
    void getAllLeagueRequestSuccess(){
        testListObjSuccess(apiFootball.leaguesApi().getAllLeague(), League.class);
    }

    @Test
    void getAllCupRequestSuccess(){
        testListObjSuccess(apiFootball.leaguesApi().getAllCup(), League.class);
    }

    @Test
    void findLeaguesByNameRequestSuccess(){
        testListObjSuccess(apiFootball.leaguesApi().findLeaguesByName("Serie A"), League.class);
    }

    @Test
    void findLeaguesByNameRequestWithInexistentLeagues(){
        testEmptyListObj(apiFootball.leaguesApi().findLeaguesByName("LaMiaStagionePreferita"), League.class);
    }

    @Test
    void findLeaguesByTeamRequestSuccess(){
        testListObjSuccess(apiFootball.leaguesApi().findLeaguesByTeam(team), League.class);
    }

    @Test
    void findLeaguesByTeamRequestWithInexistentTeam(){
        assertThrows(ApiError.class, () -> apiFootball.leaguesApi().findLeaguesByTeam(new Team()));
    }
}