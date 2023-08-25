package it.gbale.apisports.apifootball;

import it.gbale.apisports.apifootball.model.core.ApiResponse;
import it.gbale.apisports.apifootball.model.entity.Fixture;
import it.gbale.apisports.apifootball.model.entity.League;
import it.gbale.apisports.apifootball.model.entity.Season;
import it.gbale.apisports.apifootball.model.parameterEnum.FixtureParams;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;

import java.time.LocalDate;
import java.time.Year;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

class FixturesApiTest extends GenericTest<Fixture> {

    private static ApiFootball apiFootball;
    private static League league;
    private static Season season;

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");


    @BeforeAll
    static void setup() {
        if(System.getenv("SERVICETOKEN") != null){
            apiFootball = new ApiFootball(System.getenv("SERVICETOKEN"));
        }
        league = new League();
        league.setId("135");
        league.setName("Serie A");

        season = new Season();
        season.setYear(Year.now());
    }

    @Test
    @EnabledIfEnvironmentVariable(named = "SERVICETOKEN", matches = "[A-Za-z0-9@]+", disabledReason = "Token api is null or not valid")
    void findFixtureByRoundRequestSuccess() {
        List<Fixture> response = apiFootball.fixturesApi().findFixtureByRound(ZoneId.of("Europe/Rome"),"Regular Season - 2",season,league);
        this.testListObjSuccess(response, Fixture.class);
    }

    @Test
    @EnabledIfEnvironmentVariable(named = "SERVICETOKEN", matches = "[A-Za-z0-9@]+", disabledReason = "Token api is null or not valid")
    void findFixturesRequestSuccess() {
        List<Fixture> response = apiFootball.fixturesApi().findFixtures(ZoneId.of("Europe/Rome"), LocalDate.now().minusDays(3), LocalDate.now(),season, league);
        this.testListObjSuccess(response, Fixture.class);
    }

    @Test
    @EnabledIfEnvironmentVariable(named = "SERVICETOKEN", matches = "[A-Za-z0-9@]+", disabledReason = "Token api is null or not valid")
    void getAllLiveFixtureRequestSuccess() {
        List<Fixture> response = apiFootball.fixturesApi().getAllLiveFixture();
        this.testListObjSuccess(response, Fixture.class);
    }

    @Test
    @EnabledIfEnvironmentVariable(named = "SERVICETOKEN", matches = "[A-Za-z0-9@]+", disabledReason = "Token api is null or not valid")
    void getResponseRequestSuccess() {
        Map<FixtureParams,String> parameters = new HashMap<>();
        parameters.put(FixtureParams.TIMEZONE, TimeZone.getDefault().toString());
        parameters.put(FixtureParams.FROM, LocalDate.now().minusDays(3).format(formatter));
        parameters.put(FixtureParams.TO, LocalDate.now().format(formatter));
        parameters.put(FixtureParams.SEASON, season.getYear().toString());
        parameters.put(FixtureParams.LEAGUE, league.getId());
        ApiResponse<Fixture> response = apiFootball.fixturesApi().getResponse(parameters);
        this.testResponseObjSuccess(response, Fixture.class);
    }

    @Test
    @EnabledIfEnvironmentVariable(named = "SERVICETOKEN", matches = "[A-Za-z0-9@]+", disabledReason = "Token api is null or not valid")
    void findFixturesWithParamsMapRequestSuccess() {
        Map<FixtureParams,String> parameters = new HashMap<>();
        parameters.put(FixtureParams.TIMEZONE, TimeZone.getDefault().toString());
        parameters.put(FixtureParams.FROM, LocalDate.now().minusDays(3).format(formatter));
        parameters.put(FixtureParams.TO, LocalDate.now().format(formatter));
        parameters.put(FixtureParams.SEASON, season.getYear().toString());
        parameters.put(FixtureParams.LEAGUE, league.getId());
        List<Fixture> response = apiFootball.fixturesApi().findFixtures(parameters);
        this.testListObjSuccess(response, Fixture.class);
    }
}