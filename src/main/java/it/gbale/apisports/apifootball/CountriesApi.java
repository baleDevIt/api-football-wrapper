package it.gbale.apisports.apifootball;

import static it.gbale.apisports.utils.Validation.*;

import it.gbale.apisports.apifootball.model.core.ApiResponse;
import it.gbale.apisports.apifootball.model.entity.Countries;
import it.gbale.apisports.apifootball.model.parameterEnum.BaseParams;

import java.util.List;
import java.util.Map;

public class CountriesApi{

    private static final String ENDPOINT = "countries";

    private RequestFactory requestFactory;

    public CountriesApi(RequestFactory requestFactory) {
        _assertNotNull(requestFactory);
        this.requestFactory = requestFactory;
    }

    public List<Countries> getAll(){
        ApiResponse<Countries> response = requestFactory.makeRequest(ENDPOINT, null, Countries.class);
        return response.getResponse();
    }

    public List<Countries> getCountries(Map<? extends BaseParams, String> parametersRequest){
        ApiResponse<Countries> response = requestFactory.makeRequest(ENDPOINT, parametersRequest, Countries.class);
        return response.getResponse();
    }

}
