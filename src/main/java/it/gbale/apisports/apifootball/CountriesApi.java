package it.gbale.apisports.apifootball;

import static it.gbale.apisports.utils.Validation.*;

import it.gbale.apisports.apifootball.model.core.ApiResponse;
import it.gbale.apisports.apifootball.model.entity.Countries;
import it.gbale.apisports.apifootball.model.exception.InvalidParamsException;
import it.gbale.apisports.apifootball.model.parameterEnum.CountryCode;
import it.gbale.apisports.apifootball.model.parameterEnum.BaseParams;
import it.gbale.apisports.apifootball.model.parameterEnum.CountriesParams;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountriesApi{

    private static final String ENDPOINT = "countries";
    private static final Logger logger = LogManager.getLogger(CountriesApi.class);


    private final RequestFactory requestFactory;

    public CountriesApi(RequestFactory requestFactory) {
        _assertNotNull(requestFactory);
        this.requestFactory = requestFactory;
    }

    public List<Countries> getAll(){
        ApiResponse<Countries> response = requestFactory.makeRequest(ENDPOINT, null, Countries.class);
        return response.getResponse();
    }

    /**
     * Get All with ApiResponse object
     * @return ApiResponse.class
     */
    public ApiResponse<Countries> getResponse(){
        return requestFactory.makeRequest(ENDPOINT, null, Countries.class);
    }

    public List<Countries> findCountries(Map<? extends BaseParams, String> parametersRequest) throws InvalidParamsException {
        ApiResponse<Countries> response = requestFactory.makeRequest(ENDPOINT, parametersRequest, Countries.class);
        if(_isNotNull(response.getErrors()) && response.getErrors().size() > 0){
            StringBuilder builder = new StringBuilder();
            response.getErrors().forEach((key, text) -> builder.append(key).append(" - ").append(text));
            throw new InvalidParamsException(builder.toString());
        }
        logger.info(response.getErrors());
        return response.getResponse();
    }

    public List<Countries> findCountriesByName(String name){
        _assertNotNullorEmpty(name);
        ApiResponse<Countries> response = requestFactory.makeRequest(ENDPOINT, makeParams(CountriesParams.NAME,name), Countries.class);
        return response.getResponse();
    }

    @SuppressWarnings("UnusedReturnValue")
    public List<Countries> findCountriesByCode(CountryCode code){
        _assertNotNull(code);
        return requestFactory.makeRequest(ENDPOINT, makeParams(CountriesParams.CODE,code.name()), Countries.class).getResponse();
    }
    @SuppressWarnings("UnusedReturnValue")
    public List<Countries> findCountriesBySearch(String search){
        _assertNotNullorEmpty(search);
        return requestFactory.makeRequest(ENDPOINT, makeParams(CountriesParams.SEARCH,search), Countries.class).getResponse();
    }

    private Map<CountriesParams, String> makeParams(CountriesParams key, String value){
        Map<CountriesParams, String> paramsStringMap = new HashMap<>();
        paramsStringMap.put(key, value);
        return paramsStringMap;
    }
}
