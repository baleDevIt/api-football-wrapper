package it.gbale.apisports.apifootball;

import it.gbale.apisports.apifootball.model.core.ApiResponse;
import it.gbale.apisports.apifootball.model.entity.*;
import it.gbale.apisports.apifootball.model.exception.ApiError;
import it.gbale.apisports.apifootball.model.parameterEnum.FixtureParams;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.Year;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;

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
        league.setLeagueInfo(new LeagueInfo());
        league.getLeagueInfo().setId("135");
        league.getLeagueInfo().setName("Serie A");

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
        List<Fixture> response = apiFootball.fixturesApi().findFixtures(ZoneId.of("Europe/Rome"), LocalDate.now().minusDays(50), LocalDate.now(),season, league);
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
        parameters.put(FixtureParams.TIMEZONE, "Europe/Rome");
        parameters.put(FixtureParams.FROM, LocalDate.now().minusDays(50).format(formatter));
        parameters.put(FixtureParams.TO, LocalDate.now().format(formatter));
        parameters.put(FixtureParams.SEASON, season.getYear().toString());
        parameters.put(FixtureParams.LEAGUE, league.getLeagueInfo().getId());
        ApiResponse<Fixture> response = apiFootball.fixturesApi().getResponse(parameters);
        this.testResponseObjSuccess(response, Fixture.class);
    }

    @Test
    @EnabledIfEnvironmentVariable(named = "SERVICETOKEN", matches = "[A-Za-z0-9@]+", disabledReason = "Token api is null or not valid")
    void findFixturesWithParamsMapRequestSuccess() {
        Map<FixtureParams,String> parameters = new HashMap<>();
        parameters.put(FixtureParams.TIMEZONE, TimeZone.getDefault().toString());
        parameters.put(FixtureParams.FROM, LocalDate.now().minusDays(50).format(formatter));
        parameters.put(FixtureParams.TO, LocalDate.now().format(formatter));
        parameters.put(FixtureParams.SEASON, season.getYear().toString());
        parameters.put(FixtureParams.LEAGUE, league.getLeagueInfo().getId());
        List<Fixture> response = apiFootball.fixturesApi().findFixtures(parameters);
        this.testListObjSuccess(response, Fixture.class);
    }

    @Test
    @EnabledIfEnvironmentVariable(named = "SERVICETOKEN", matches = "[A-Za-z0-9@]+", disabledReason = "Token api is null or not valid")
    void verifyCorrectDeserializationFixture() {
        Fixture fixture = apiFootball.fixturesApi().findFixturebyId(877942).orElseThrow(() -> new ApiError("Fixture id 877942 not find"));
        assertNotNull(fixture.getId(), "Id is null");
        assertNotNull(fixture.getReferee(), " Referee is null");
        assertNotNull(fixture.getTimezone(), "Timezone is null");
        assertNotNull(fixture.getTimestamp(), "Timestampo is null");
        assertNotNull(fixture.getPeriod(), "Period is null");
        assertNotNull(fixture.getVenue(), "Venue is null");
        assertNotNull(fixture.getGameStatus(), "GameStatus is null");
        assertNotNull(fixture.getLeague(), "League is null");
        assertNotNull(fixture.getTeams(), "Teams is null");
        assertNotNull(fixture.getScore(), "Score is null");
        assertNotNull(fixture.getGoals(), "Goals is null");
    }

    @Test
    @EnabledIfEnvironmentVariable(named = "SERVICETOKEN", matches = "[A-Za-z0-9@]+", disabledReason = "Token api is null or not valid")
    void findRoundByLeague_RequestSuccess() {
        List<String> roundsByCurrentLeague = apiFootball.fixturesApi().findRoundsByLeague("2023", "135");
        assertNotNull(roundsByCurrentLeague);
        assertNotEquals("", roundsByCurrentLeague.get(0).trim());
    }


    @Test
    @EnabledIfEnvironmentVariable(named = "SERVICETOKEN", matches = "[A-Za-z0-9@]+", disabledReason = "Token api is null or not valid")
    void findHeadToHeadWithNumberOfEvent() {
        List<Fixture> headToHead = apiFootball.fixturesApi().findHeadToHead("33", "34", 1);
        testListObjSuccess(headToHead, Fixture.class);
        assertEquals(1, headToHead.size());
    }

    @Test
    @EnabledIfEnvironmentVariable(named = "SERVICETOKEN", matches = "[A-Za-z0-9@]+", disabledReason = "Token api is null or not valid")
    void findHeadToHead() {
        List<Fixture> headToHead = apiFootball.fixturesApi().findHeadToHead("33", "34");
        testListObjSuccess(headToHead, Fixture.class);
        assertNotEquals(1, headToHead.size());
    }

    @Test
    @EnabledIfEnvironmentVariable(named = "SERVICETOKEN", matches = "[A-Za-z0-9@]+", disabledReason = "Token api is null or not valid")
    void getStatistics() {
        List<FixtureStatistics> fixtureStatistics = apiFootball.fixturesApi().getStatistics(215662);
        assertEquals(2, fixtureStatistics.size());
        //Tester Entry Deserialization
        FixtureStatistics entry = fixtureStatistics.get(0);
        if(entry.getTeamId() != 463){
            entry = fixtureStatistics.get(1);
        }
        assertEquals(463, entry.getTeamId(), "Team id is incorrect");
        assertEquals("Aldosivi", entry.getTeamName());
        assertEquals(3, entry.getShotsOnGoal());
        assertEquals(2, entry.getShotsOffGoal());
        assertEquals(9, entry.getTotalShots());
        assertEquals(0, entry.getGoalkeeperSaves());
        assertEquals("50%", entry.getPasses());
        assertEquals("32%", entry.getBallPossession());
    }

    @Test
    @EnabledIfEnvironmentVariable(named = "SERVICETOKEN", matches = "[A-Za-z0-9@]+", disabledReason = "Token api is null or not valid")
    void getEvents() {
        List<FixtureEvent> eventList = apiFootball.fixturesApi().getEvents(215662);

        Optional<FixtureEvent> event = eventList.stream().filter(fe -> fe.getEventTimeProperty().getElapsed() == 25 && fe.getTypeEvent().equalsIgnoreCase("Goal")).findFirst();
        assertTrue(event.isPresent());
        assertEquals("Aldosivi", event.get().getTeamProperty().getTeamName());
        assertEquals("F. Andrada", event.get().getEventPlayerProperty().getPlayerName());
    }

    @Test
    @EnabledIfEnvironmentVariable(named = "SERVICETOKEN", matches = "[A-Za-z0-9@]+", disabledReason = "Token api is null or not valid")
    void getLineups() {
        List<FixtureLineup> eventList = apiFootball.fixturesApi().getLineups(592872);

        Optional<FixtureLineup> lineup = eventList.stream().filter(ln -> ln.getTeamLineupProperty().getTeamId() == 50).findFirst();
        assertTrue(lineup.isPresent());
        assertEquals("Manchester City", lineup.get().getTeamLineupProperty().getTeamName());
        assertEquals("Ederson", lineup.get().getStartXI().stream().filter(tmpLineup -> tmpLineup.getPlayerLineupProperty().getPlayerId() == 617).findFirst().orElseThrow(ApiError::new).getPlayerLineupProperty().getPlayerName());
        assertEquals("Guardiola", lineup.get().getCoach().getCoachName());
    }

    @Test
    @EnabledIfEnvironmentVariable(named = "SERVICETOKEN", matches = "[A-Za-z0-9@]+", disabledReason = "Token api is null or not valid")
    void getPlayerStatistics() {
        List<PlayerFixtureStatistics> fixtureStatistics = apiFootball.fixturesApi().getPlayerStatistics(169080);

        Optional<PlayerFixtureStatistics> statistics = fixtureStatistics.stream().filter(ln -> ln.getTeam().getId() == 2284).findFirst();
        assertTrue(statistics.isPresent());
        //Validate Team Serializable
        assertEquals("Monarcas", statistics.get().getTeam().getName());

        Player player = statistics.get().getPlayers().stream().filter(pl -> pl.getPlayerInfo().getId() == 35931).findFirst().orElseThrow(ApiError::new);
        //Validate Player Serializable
        //Playerinfo
        assertEquals("Sebastián Sosa", player.getPlayerInfo().getName());
        assertNotNull(player.getPlayerInfo().getLogo());

        PlayerStatistics playerStatistics = player.getPlayerStatistics().stream().findFirst().orElseThrow(ApiError::new);
        // getGameStatistics() Serializable
        assertEquals(90, playerStatistics.getGameStatistics().getMinutes());
        assertEquals(13, playerStatistics.getGameStatistics().getNumber());
        assertEquals("G", playerStatistics.getGameStatistics().getPosition());
        assertEquals("6.3", playerStatistics.getGameStatistics().getRating());
        assertEquals(false, playerStatistics.getGameStatistics().getCaptain());
        assertEquals(false, playerStatistics.getGameStatistics().getSubstitute());

        // getShotsStatistics() Serializable
        assertEquals(0, playerStatistics.getShotsStatistics().getTotal());
        assertEquals(0, playerStatistics.getShotsStatistics().getOn());

        // getGoalsStatistics() Serializable
        assertNull(playerStatistics.getGoalsStatistics().getTotal());
        assertEquals(1, playerStatistics.getGoalsStatistics().getConceded());
        assertNull(playerStatistics.getGoalsStatistics().getAssists());
        assertEquals(1, playerStatistics.getGoalsStatistics().getSaves());

        // getPassesStatistics() Serializable
        assertEquals(17, playerStatistics.getPassesStatistics().getTotal());
        assertEquals(0, playerStatistics.getPassesStatistics().getKey());
        assertEquals("68%", playerStatistics.getPassesStatistics().getAccuracy());

        // getTacklesStatistics() Serializable
        assertNull(playerStatistics.getTacklesStatistics().getTotal());
        assertEquals(0, playerStatistics.getTacklesStatistics().getBlocks());
        assertEquals(0, playerStatistics.getTacklesStatistics().getInterceptions());

        // getDuelsStatistics() Serializable
        assertEquals(0, playerStatistics.getDuelsStatistics().getTotal());
        assertEquals(0, playerStatistics.getDuelsStatistics().getWon());

        // getDribblesStatistics() Serializable
        assertEquals(0, playerStatistics.getDribblesStatistics().getAttempts());
        assertEquals(0, playerStatistics.getDribblesStatistics().getSuccess());
        assertNull(playerStatistics.getDribblesStatistics().getPast());

        // getFoulsStatistics() Serializable
        assertEquals(0, playerStatistics.getFoulsStatistics().getDrawn());
        assertEquals(0, playerStatistics.getFoulsStatistics().getCommitted());

        // getDuelsStatistics() Serializable
        assertEquals(0, playerStatistics.getCardsStatistics().getYellow());
        assertEquals(0, playerStatistics.getCardsStatistics().getRed());

        // getPenaltyStatistics() Serializable
        assertNull(playerStatistics.getPenaltyStatistics().getWon());
        assertNull(playerStatistics.getPenaltyStatistics().getCommited());
        assertEquals(0, playerStatistics.getPenaltyStatistics().getScored());
        assertEquals(0, playerStatistics.getPenaltyStatistics().getMissed());
        assertEquals(0, playerStatistics.getPenaltyStatistics().getSaved());
    }
}