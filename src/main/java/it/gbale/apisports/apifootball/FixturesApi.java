package it.gbale.apisports.apifootball;

import it.gbale.apisports.apifootball.model.core.ApiResponse;
import it.gbale.apisports.apifootball.model.entity.Fixture;
import it.gbale.apisports.apifootball.model.entity.League;
import it.gbale.apisports.apifootball.model.entity.Season;
import it.gbale.apisports.apifootball.model.parameterEnum.BaseParams;
import it.gbale.apisports.apifootball.model.parameterEnum.FixtureParams;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static it.gbale.apisports.utils.Validation._assertNotNull;

public class FixturesApi extends BaseApi {

    private static final String ENDPOINT = "fixtures";
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
        parameters.put(FixtureParams.LEAGUE, league.getId());
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
        parameters.put(FixtureParams.LEAGUE, league.getId());
        return getResponse(parameters).getResponse();

    }

    public List<Fixture> findFixtures(Map<? extends BaseParams, String> parametersRequest){
        _assertNotNull(parametersRequest);
        return getResponse(parametersRequest).getResponse();
    }

    public ApiResponse<Fixture> getResponse(Map<? extends BaseParams, String> parametersRequest){
        _assertNotNull(parametersRequest);
        return requestFactory.makeRequest(ENDPOINT, parametersRequest, Fixture.class);
    }

    /**
     * Return all live fixtures games
     */
    public List<Fixture> getAllLiveFixture(){
        return getResponse(makeParams(FixtureParams.LIVE, "all")).getResponse();
    }

}
