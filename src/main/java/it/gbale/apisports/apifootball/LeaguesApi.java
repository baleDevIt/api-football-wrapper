package it.gbale.apisports.apifootball;

import it.gbale.apisports.apifootball.model.core.ApiResponse;
import it.gbale.apisports.apifootball.model.entity.League;
import it.gbale.apisports.apifootball.model.entity.Season;
import it.gbale.apisports.apifootball.model.entity.Team;
import it.gbale.apisports.apifootball.model.parameterEnum.BaseParams;
import it.gbale.apisports.apifootball.model.parameterEnum.LeaguesParams;

import java.time.Year;
import java.util.List;
import java.util.Map;

import static it.gbale.apisports.utils.Validation.*;

public class LeaguesApi extends BaseApi{

    private static final String ENDPOINT = "leagues";

    private final RequestFactory requestFactory;

    public LeaguesApi(RequestFactory requestFactory) {
        _assertNotNull(requestFactory);
        this.requestFactory = requestFactory;
    }

    /**
     * Return the list of current seasons or the last one of each competition
     */
    public List<League> getAllCurrentLeagues(){
        return requestFactory.makeRequest(ENDPOINT, makeParams(LeaguesParams.CURRENT, "true"), League.class).getResponse();
    }

    public List<League> getAllLeagues(){
        return requestFactory.makeRequest(ENDPOINT, null, League.class).getResponse();
    }

    public ApiResponse<League> getResponse(){
        return requestFactory.makeRequest(ENDPOINT, null, League.class);
    }

    public List<League> findLeagues(Map<? extends BaseParams, String> parametersRequest){
        return requestFactory.makeRequest(ENDPOINT, parametersRequest, League.class).getResponse();
    }

    /**
     * Return the list of specific seasons year
     */
    public List<League> findLeaguesAtSeason(Year year){
        _assertNotNull(year);
        return requestFactory.makeRequest(ENDPOINT, makeParams(LeaguesParams.SEASON, year.getValue()), League.class).getResponse();
    }

    /**
     * Return the list of specific seasons year
     */
    @SuppressWarnings("UnusedReturnValue")
    public List<League> findLeaguesAtSeason(Season season){
        _assertNotNull(season);
        _assertNotNull(season.getYear());
        return requestFactory.makeRequest(ENDPOINT, makeParams(LeaguesParams.SEASON, season.getYear().getValue()), League.class).getResponse();
    }

    /**
     * Return the list of specific seasons year
     */
    public List<League> searchLeagues(String search){
        _assertNotNullorEmpty(search);
        return requestFactory.makeRequest(ENDPOINT, makeParams(LeaguesParams.SEARCH, search), League.class).getResponse();
    }

    public List<League> getAllLeague(){
        //TODO: Rename method
        return requestFactory.makeRequest(ENDPOINT, makeParams(LeaguesParams.TYPE, "League"), League.class).getResponse();
    }

    public List<League> getAllCup(){
        return requestFactory.makeRequest(ENDPOINT, makeParams(LeaguesParams.TYPE, "Cup"), League.class).getResponse();
    }

    public List<League> findLeaguesByTeam(Team team){
        _assertNotNull(team);
        return requestFactory.makeRequest(ENDPOINT, makeParams(LeaguesParams.TEAM, team.getId()), League.class).getResponse();
    }

    public List<League> findLeaguesByName(String leagueName){
        _assertNotNullorEmpty(leagueName);
        return requestFactory.makeRequest(ENDPOINT, makeParams(LeaguesParams.NAME, leagueName), League.class).getResponse();
    }


}
