package it.gbale.apisports.apifootball;

import it.gbale.apisports.apifootball.model.entity.League;
import it.gbale.apisports.apifootball.model.entity.Season;
import it.gbale.apisports.apifootball.model.entity.Team;
import it.gbale.apisports.apifootball.model.exception.ApiError;
import it.gbale.apisports.apifootball.model.parameterEnum.LeaguesParams;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;

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
        if(System.getenv("SERVICETOKEN") != null){
            apiFootball = new ApiFootball(System.getenv("SERVICETOKEN"));
        }
        team = new Team();
        team.setId(33);
        team.setName("Manchester United");
        team.setCode("MUN");
    }
    @EnabledIfEnvironmentVariable(named = "SERVICETOKEN", matches = "[A-Za-z0-9@]+", disabledReason = "Token api is null or not valid")
    @Test
    void getAllCurrentLeaguesSuccess(){
        testListObjSuccess(apiFootball.leaguesApi().getAllCurrentLeagues(), League.class) ;
    }

    @EnabledIfEnvironmentVariable(named = "SERVICETOKEN", matches = "[A-Za-z0-9@]+", disabledReason = "Token api is null or not valid")
    @Test
    void getAllRequestSuccess(){
        testListObjSuccess(apiFootball.leaguesApi().getAllLeagues(), League.class);
    }

    @EnabledIfEnvironmentVariable(named = "SERVICETOKEN", matches = "[A-Za-z0-9@]+", disabledReason = "Token api is null or not valid")
    @Test
    void getResponseSuccess(){
        testResponseObjSuccess(apiFootball.leaguesApi().getResponse(),League.class);

    }

    @EnabledIfEnvironmentVariable(named = "SERVICETOKEN", matches = "[A-Za-z0-9@]+", disabledReason = "Token api is null or not valid")
    @Test
    void findLeaguesRequestSuccess(){
        Map<LeaguesParams, String> paramsStringMap = new HashMap<>();
        paramsStringMap.put(LeaguesParams.CURRENT, "true");
        List<League> leagues = apiFootball.leaguesApi().findLeagues(paramsStringMap);
        assertNotNull(leagues, "Response List of League is null");
        assertNotEquals(leagues.size(), 0, "Response List of League do not have element");
        leagues.forEach(element -> assertInstanceOf(League.class, element));
    }

    @EnabledIfEnvironmentVariable(named = "SERVICETOKEN", matches = "[A-Za-z0-9@]+", disabledReason = "Token api is null or not valid")
    @Test
    void findCountriesRequestWithCodeParameterNotValid(){
        Map<LeaguesParams, String> paramsStringMap = new HashMap<>();
        paramsStringMap.put(LeaguesParams.CURRENT, "ciccio");
        assertThrows(ApiError.class, () -> apiFootball.leaguesApi().findLeagues(paramsStringMap));
    }

    @Test
    @EnabledIfEnvironmentVariable(named = "SERVICETOKEN", matches = "[A-Za-z0-9@]+", disabledReason = "Token api is null or not valid")
    void findLeaguesAtSeasonRequestWithNullYearValue(){
        assertThrows(IllegalArgumentException.class, () -> apiFootball.leaguesApi().findLeaguesAtSeason((Year) null));
    }

    @Test
    @EnabledIfEnvironmentVariable(named = "SERVICETOKEN", matches = "[A-Za-z0-9@]+", disabledReason = "Token api is null or not valid")
    void findLeaguesAtSeasonRequestWithNullSeasonValue(){
        assertThrows(IllegalArgumentException.class, () -> apiFootball.leaguesApi().findLeaguesAtSeason((Season) null));
    }

    @Test
    @EnabledIfEnvironmentVariable(named = "SERVICETOKEN", matches = "[A-Za-z0-9@]+", disabledReason = "Token api is null or not valid")
    void findLeaguesAtSeasonRequestActualYear(){
        testListObjSuccess(apiFootball.leaguesApi().findLeaguesAtSeason(Year.now()), League.class);
    }

    @Test
    @EnabledIfEnvironmentVariable(named = "SERVICETOKEN", matches = "[A-Za-z0-9@]+", disabledReason = "Token api is null or not valid")
    void findLeaguesRequest(){
        testListObjSuccess(apiFootball.leaguesApi().searchLeagues("Serie A"), League.class);
    }

    @Test
    @EnabledIfEnvironmentVariable(named = "SERVICETOKEN", matches = "[A-Za-z0-9@]+", disabledReason = "Token api is null or not valid")
    void findLeaguesRequestWithInexistentLeagues(){
        testEmptyListObj(apiFootball.leaguesApi().searchLeagues("LaMiaStagionePreferita"), League.class);
    }

    @Test
    @EnabledIfEnvironmentVariable(named = "SERVICETOKEN", matches = "[A-Za-z0-9@]+", disabledReason = "Token api is null or not valid")
    void getAllLeagueRequestSuccess(){
        testListObjSuccess(apiFootball.leaguesApi().getAllLeague(), League.class);
    }

    @Test
    @EnabledIfEnvironmentVariable(named = "SERVICETOKEN", matches = "[A-Za-z0-9@]+", disabledReason = "Token api is null or not valid")
    void getAllCupRequestSuccess(){
        testListObjSuccess(apiFootball.leaguesApi().getAllCup(), League.class);
    }

    @Test
    @EnabledIfEnvironmentVariable(named = "SERVICETOKEN", matches = "[A-Za-z0-9@]+", disabledReason = "Token api is null or not valid")
    void findLeaguesByNameRequestSuccess(){
        testListObjSuccess(apiFootball.leaguesApi().findLeaguesByName("Serie A"), League.class);
    }

    @Test
    @EnabledIfEnvironmentVariable(named = "SERVICETOKEN", matches = "[A-Za-z0-9@]+", disabledReason = "Token api is null or not valid")
    void findLeaguesByNameRequestWithInexistentLeagues(){
        testEmptyListObj(apiFootball.leaguesApi().findLeaguesByName("LaMiaStagionePreferita"), League.class);
    }

    @Test
    @EnabledIfEnvironmentVariable(named = "SERVICETOKEN", matches = "[A-Za-z0-9@]+", disabledReason = "Token api is null or not valid")
    void findLeaguesByTeamRequestSuccess(){
        testListObjSuccess(apiFootball.leaguesApi().findLeaguesByTeam(team), League.class);
    }

    @Test
    @EnabledIfEnvironmentVariable(named = "SERVICETOKEN", matches = "[A-Za-z0-9@]+", disabledReason = "Token api is null or not valid")
    void findLeaguesByTeamRequestWithInexistentTeam(){
        assertThrows(ApiError.class, () -> apiFootball.leaguesApi().findLeaguesByTeam(new Team()));
    }

    @Test
    @EnabledIfEnvironmentVariable(named = "SERVICETOKEN", matches = "[A-Za-z0-9@]+", disabledReason = "Token api is null or not valid")
    void checkBasicInformationInLeagueEntity(){
        List<League> allLeague = apiFootball.leaguesApi().getAllLeague();
        assertNotNull(allLeague.get(0).getLeagueInfo().getId(), "League getId is null");
        assertNotNull(allLeague.get(0).getLeagueInfo().getLogo(), "League getLogo is null");
        assertNotNull(allLeague.get(0).getLeagueInfo().getName(), "League getName is null");
        assertNotNull(allLeague.get(0).getLeagueInfo().getType(), "League getType is null");
    }
}