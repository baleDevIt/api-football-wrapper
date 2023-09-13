package it.gbale.apisports.apifootball;

import it.gbale.apisports.apifootball.model.core.ApiResponse;
import it.gbale.apisports.apifootball.model.entity.*;
import it.gbale.apisports.apifootball.model.parameterEnum.BaseParams;
import it.gbale.apisports.apifootball.model.parameterEnum.FixtureParams;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static it.gbale.apisports.utils.Validation._assertNotNull;
import static it.gbale.apisports.utils.Validation._assertNotNullorEmpty;

@SuppressWarnings("unused")
public class FixturesApi extends BaseApi {

    private static final String FIXTURES = "fixtures";
    private static final String ROUNDS = FIXTURES+"/rounds";
    private static final String HEADTOHEAD = FIXTURES+"/headtohead";
    private static final String STATISTIC = FIXTURES+"/statistics";
    private static final String EVENTS = FIXTURES + "/events";
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    private final RequestFactory requestFactory;

    public FixturesApi(RequestFactory requestFactory) {
        _assertNotNull(requestFactory);
        this.requestFactory = requestFactory;
    }

    public List<Fixture> findFixtureByRound(ZoneId timezone,String round, Season season, League league){
        _assertNotNull(timezone, round, league);
        Map<FixtureParams,String> parameters = new HashMap<>();
        parameters.put(FixtureParams.TIMEZONE, timezone.toString());
        parameters.put(FixtureParams.ROUND, round);
        parameters.put(FixtureParams.LEAGUE, league.getLeagueInfo().getId());
        parameters.put(FixtureParams.SEASON, season.getYear().toString());
        return getResponse(parameters).getResponse();
    }


    public List<Fixture> findFixtures(ZoneId timezone, LocalDate from, LocalDate to, Season season, League league){
        _assertNotNull(timezone, from, to, season, league);
        Map<FixtureParams,String> parameters = new HashMap<>();
        parameters.put(FixtureParams.TIMEZONE, timezone.toString());
        parameters.put(FixtureParams.FROM, from.format(formatter));
        parameters.put(FixtureParams.TO, to.format(formatter));
        parameters.put(FixtureParams.SEASON, season.getYear().toString());
        parameters.put(FixtureParams.LEAGUE, league.getLeagueInfo().getId());
        return getResponse(parameters).getResponse();

    }

    public List<Fixture> findFixtures(Map<? extends BaseParams, String> parametersRequest){
        _assertNotNull(parametersRequest);
        return getResponse(parametersRequest).getResponse();
    }

    public ApiResponse<Fixture> getResponse(Map<? extends BaseParams, String> parametersRequest){
        _assertNotNull(parametersRequest);
        return requestFactory.makeRequest(FIXTURES, parametersRequest, Fixture.class);
    }

    /**
     * Return all live fixtures games
     */
    public List<Fixture> getAllLiveFixture(){
        return getResponse(makeParams(FixtureParams.LIVE, "all")).getResponse();
    }

    /**
     * Return a specific Fixture by id
     */
    public Optional<Fixture> findFixturebyId(Integer id){
        _assertNotNull(id);
        return getResponse(makeParams(FixtureParams.ID, id)).getResponse().stream().findFirst();
    }

    public List<Fixture> findFixturebyDate(LocalDate localDate){
        _assertNotNull(localDate);
        return getResponse(makeParams(FixtureParams.DATE, localDate.format(formatter))).getResponse();
    }

    public List<Fixture> findFixtureforTeamId(Integer teamId){
        _assertNotNull(teamId);
        return getResponse(makeParams(FixtureParams.TEAM, teamId)).getResponse();
    }

    /**
     * Return the next N Fixtures of a specific League
     */

    public List<Fixture> getNextFixturebyLeagueId(Integer league, Integer nValueNext){
        _assertNotNull(league);
        if(nValueNext == null){
            nValueNext = 1;
        }
        Map<BaseParams, String> params = Map.of(FixtureParams.TEAM, String.valueOf(league), FixtureParams.NEXT, String.valueOf(nValueNext));
        return getResponse(params).getResponse();
    }

    /**
     * Return the last N Fixtures of a specific League
     */

    public List<Fixture> getLastFixturebyLeagueId(Integer league, Integer nValueLast){
        _assertNotNull(league);
        if(nValueLast == null){
            nValueLast = 1;
        }
        Map<BaseParams, String> params = Map.of(FixtureParams.TEAM, String.valueOf(league), FixtureParams.LAST, String.valueOf(nValueLast));
        return getResponse(params).getResponse();
    }


    /**
     * Get the rounds for a league or a cup.
     */
    public List<String> findRoundsByLeague(String season, String league){
        _assertNotNullorEmpty(season, league);
        return requestFactory.makeRequest(ROUNDS, Map.of(FixtureParams.SEASON, season, FixtureParams.LEAGUE, league), String.class).getResponse();
    }

    /**
     * Get heads to heads between two teams.
     */
    public List<Fixture> findHeadToHead(String firstIdTeam, String secondIdTeam, Integer numberOfEvent){
        _assertNotNullorEmpty(firstIdTeam, secondIdTeam);
        String h2hParam = firstIdTeam + "-" + secondIdTeam;
        if(numberOfEvent == null){
            return requestFactory.makeRequest(HEADTOHEAD, Map.of(FixtureParams.H2H, h2hParam), Fixture.class).getResponse();
        }
        return requestFactory.makeRequest(HEADTOHEAD, Map.of(FixtureParams.H2H, h2hParam, FixtureParams.LAST, String.valueOf(numberOfEvent)), Fixture.class).getResponse();
    }

    public List<Fixture> findHeadToHead(String firstIdTeam, String secondIdTeam){
        return this.findHeadToHead(firstIdTeam, secondIdTeam, null);
    }

    public List<Fixture> findHeadToHead(Integer firstIdTeam, Integer secondIdTeam){
        _assertNotNull(firstIdTeam, secondIdTeam);
        return this.findHeadToHead(String.valueOf(firstIdTeam), String.valueOf(secondIdTeam));
    }

    public List<Fixture> findHeadToHead(Team firstTeam, Team secondTeam){
        _assertNotNull(firstTeam, secondTeam);
        return this.findHeadToHead(firstTeam.getId(), secondTeam.getId());
    }

    /**
     * Get the statistics for one fixture. Available statistics;
     * - Shots on Goal
     * - Shots off Goal
     * - Shots insidebox
     * - Shots outsidebox
     * - Total Shots
     * - Blocked Shots
     * - Fouls
     * - Corner Kicks
     * - Offsides
     * - Ball Possession
     * - Yellow Cards
     * - Red Cards
     * - Goalkeeper Saves
     * - Total passes
     * - Passes accurate
     * - Passes %
     */
    public List<FixtureStatistics> getStatistics(Integer fixtureId){
        return requestFactory.makeRequest(STATISTIC, Map.of(FixtureParams.FIXTURE, String.valueOf(fixtureId)), FixtureStatistics.class).getResponse();
    }

    /**
     * Get the events from a fixture.
     */
    public List<FixtureEvent> getEvents(Integer fixtureId){
        return requestFactory.makeRequest(EVENTS, Map.of(FixtureParams.FIXTURE, String.valueOf(fixtureId)), FixtureEvent.class).getResponse();
    }

}
