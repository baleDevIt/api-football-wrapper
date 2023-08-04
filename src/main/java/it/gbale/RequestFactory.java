package it.gbale;

import static it.gbale.utils.Validation.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.Header;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.message.BasicHeader;

final class RequestFactory {

    private static final String APISPORTS_URL = "https://v3.football.api-sports.io/";
    private static final String RAPID_API_URL = "https://api-football-v1.p.rapidapi.com/v3/";
    private static final Header V3_FOOTBALL_HOST_HEADER = new BasicHeader("x-rapidapi-host","v3.football.api-sports.io");
    private static final String RAPIDAPI_HEADER_KEY = "x-rapidapi-key";
    private Header headerToken;
    private final ObjectMapper mapper;
    private String activeEndpoint;


    public RequestFactory(String activeToken, boolean isApiSportsEndpoint) {
        _assertNotNullorEmpty(activeToken);

        if(isApiSportsEndpoint){
            this.activeEndpoint = APISPORTS_URL;
        }else{
            this.activeEndpoint = RAPID_API_URL;
        }
        this.headerToken = new BasicHeader(RAPIDAPI_HEADER_KEY, activeToken);
        this.mapper = new ObjectMapper();
    }

    /**
     * Semplice costruttore che permette di creare un RequestFactory
     * impostato con Endpoint RAPID API URL (https://api-football-v1.p.rapidapi.com/v3/)
     * @param activeToken
     */
    public RequestFactory(String activeToken) {
        this(activeToken,true);
    }


    /**
     * Restituisce una richiesta preformattata per l'endpoint Countries
     * https://www.api-football.com/documentation-v3#tag/Countries/operation/get-countries
     * @return HttpGet
     */
    public HttpGet getCountriesReq(){
        HttpGet request = new HttpGet(activeEndpoint+"countries");
        request.addHeader(V3_FOOTBALL_HOST_HEADER);
        request.addHeader(headerToken);
        return request;
    }


}
