package it.gbale.apisports.apifootball;

import static it.gbale.apisports.utils.Validation.*;

import it.gbale.apisports.apifootball.model.core.ApiResponse;
import it.gbale.apisports.apifootball.model.entity.Country;
import it.gbale.apisports.apifootball.model.exception.InvalidParamsException;
import it.gbale.apisports.apifootball.model.parameterEnum.CountryCode;
import it.gbale.apisports.apifootball.model.parameterEnum.BaseParams;
import it.gbale.apisports.apifootball.model.parameterEnum.CountriesParams;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountriesApi extends BaseApi {

    private static final String ENDPOINT = "countries";
    private static final Logger logger = LogManager.getLogger(CountriesApi.class);


    private final RequestFactory requestFactory;

    public CountriesApi(RequestFactory requestFactory) {
        _assertNotNull(requestFactory);
        this.requestFactory = requestFactory;
    }

    public List<Country> getAll(){
        ApiResponse<Country> response = requestFactory.makeRequest(ENDPOINT, null, Country.class);
        return response.getResponse();
    }

    /**
     * Get All with ApiResponse object
     * @return ApiResponse.class
     */
    public ApiResponse<Country> getResponse(){
        return requestFactory.makeRequest(ENDPOINT, null, Country.class);
    }

    public List<Country> findCountries(Map<? extends BaseParams, String> parametersRequest) throws InvalidParamsException {
        ApiResponse<Country> response = requestFactory.makeRequest(ENDPOINT, parametersRequest, Country.class);
        if(_isNotNull(response.getErrors()) && response.getErrors().size() > 0){
            StringBuilder builder = new StringBuilder();
            response.getErrors().forEach((key, text) -> builder.append(key).append(" - ").append(text));
            throw new InvalidParamsException(builder.toString());
        }
        logger.info(response.getErrors());
        return response.getResponse();
    }

    public List<Country> findCountriesByName(String name){
        _assertNotNullorEmpty(name);
        ApiResponse<Country> response = requestFactory.makeRequest(ENDPOINT, makeParams(CountriesParams.NAME,name), Country.class);
        return response.getResponse();
    }

    @SuppressWarnings("UnusedReturnValue")
    public List<Country> findCountriesByCode(CountryCode code){
        _assertNotNull(code);
        return requestFactory.makeRequest(ENDPOINT, makeParams(CountriesParams.CODE,code.name()), Country.class).getResponse();
    }
    @SuppressWarnings("UnusedReturnValue")
    public List<Country> findCountriesBySearch(String search){
        _assertNotNullorEmpty(search);
        return requestFactory.makeRequest(ENDPOINT, makeParams(CountriesParams.SEARCH,search), Country.class).getResponse();
    }

    private Map<CountriesParams, String> makeParams(CountriesParams key, String value){
        Map<CountriesParams, String> paramsStringMap = new HashMap<>();
        paramsStringMap.put(key, value);
        return paramsStringMap;
    }
}
