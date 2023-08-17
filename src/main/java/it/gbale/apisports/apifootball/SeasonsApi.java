package it.gbale.apisports.apifootball;

import static it.gbale.apisports.utils.Validation.*;

import it.gbale.apisports.apifootball.model.core.ApiResponse;

import java.time.Year;
import java.util.*;

public class SeasonsApi extends BaseApi {

    private static final String ENDPOINT = "leagues/seasons";

    private static final List<String> offlineSeason = Arrays.asList("2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026");


    private final RequestFactory requestFactory;

    public SeasonsApi(RequestFactory requestFactory) {
        _assertNotNull(requestFactory);
        this.requestFactory = requestFactory;
    }

    public List<String> getAll_withRequest(){
        return requestFactory.makeRequest(ENDPOINT, null, String.class).getResponse();
    }

    /**
     * Return all season without make a request.
     * Update max 2026
     */
    public List<String> getAll(){
        return Collections.unmodifiableList(offlineSeason);
    }

    /**
     * Get All with ApiResponse object
     * @return ApiResponse.class
     */
    public ApiResponse<String> getResponse(){
        return requestFactory.makeRequest(ENDPOINT, null, String.class);
    }

    public String getActualSeason(){
        return Year.now().toString();
    }



}

