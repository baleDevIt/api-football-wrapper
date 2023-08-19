package it.gbale.apisports.apifootball;

import it.gbale.apisports.apifootball.model.core.ApiResponse;
import it.gbale.apisports.apifootball.model.entity.League;
import it.gbale.apisports.apifootball.model.exception.InvalidParamsException;
import it.gbale.apisports.apifootball.model.parameterEnum.BaseParams;
import it.gbale.apisports.apifootball.model.parameterEnum.LeaguesParams;

import java.util.List;
import java.util.Map;

import static it.gbale.apisports.utils.Validation._assertNotNull;
import static it.gbale.apisports.utils.Validation._isNotNull;

public class LeaguesApi extends BaseApi{

    private static final String ENDPOINT = "leagues";

    private final RequestFactory requestFactory;

    public LeaguesApi(RequestFactory requestFactory) {
        _assertNotNull(requestFactory);
        this.requestFactory = requestFactory;
    }

    /**
     * Return the list of active seasons or the last one of each competition
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

    public List<League> findLeagues(Map<? extends BaseParams, String> parametersRequest) throws InvalidParamsException {
        ApiResponse<League> response = requestFactory.makeRequest(ENDPOINT, parametersRequest, League.class);
        if(_isNotNull(response.getErrors()) && response.getErrors().size() > 0){
            StringBuilder builder = new StringBuilder();
            response.getErrors().forEach((key, text) -> builder.append(key).append(" - ").append(text));
            throw new InvalidParamsException(builder.toString());
        }
        return response.getResponse();
    }


}
