package it.gbale.apisports.apifootball;

import static it.gbale.apisports.utils.Validation.*;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import it.gbale.apisports.apifootball.adapter.LocalDateTypeAdapter;
import it.gbale.apisports.apifootball.adapter.YearTypeAdapter;
import it.gbale.apisports.apifootball.adapter.ZoneIdTypeAdapter;
import it.gbale.apisports.apifootball.model.core.ApiResponse;
import it.gbale.apisports.apifootball.model.exception.ApiError;
import it.gbale.apisports.apifootball.model.parameterEnum.BaseParams;
import org.apache.http.Header;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.time.Year;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

final class RequestFactory {

    private static final String APISPORTS_URL = "https://v3.football.api-sports.io/";
    private static final String RAPID_API_URL = "https://api-football-v1.p.rapidapi.com/v3/";
    private static final Header V3_FOOTBALL_HOST_HEADER = new BasicHeader("x-rapidapi-host","v3.football.api-sports.io");
    private static final String RAPIDAPI_HEADER_KEY = "x-rapidapi-key";
    private static final Logger logger = LogManager.getLogger(RequestFactory.class);
    private final Header headerToken;
    private final Gson gson;
    private final String activeEndpoint;
    private final CloseableHttpClient client;





    RequestFactory(String activeToken, boolean isApiSportsEndpoint) {
        _assertNotNullorEmpty(activeToken);

        if(isApiSportsEndpoint){
            this.activeEndpoint = APISPORTS_URL;
        }else{
            this.activeEndpoint = RAPID_API_URL;
        }
        this.headerToken = new BasicHeader(RAPIDAPI_HEADER_KEY, activeToken);
        this.gson = new GsonBuilder()
                .registerTypeAdapter(ZoneId.class, new ZoneIdTypeAdapter())
                .registerTypeAdapter(LocalDate.class, new LocalDateTypeAdapter())
                .registerTypeAdapter(Year.class, new YearTypeAdapter())
                .create();
        this.client = HttpClients.createDefault();
    }

    /**
     * Restituisce una richiesta preformattata per il terminalEndpoint specificato
     * Es.
     * - v3.football.api-sports.io/[terminalEndpoint]
     * - api-football-v1.p.rapidapi.com/v3/[terminalEndpoint]
     */
    HttpGet buildRequest(String terminalEndpoint, Map<String,String> parameters){
        URI uri = _URIMaker(activeEndpoint,terminalEndpoint, parameters);
        HttpGet request = new HttpGet(uri);
        request.addHeader(V3_FOOTBALL_HOST_HEADER);
        request.addHeader(headerToken);
        return request;
    }

    @SuppressWarnings("unused")
    HttpGet buildRequest(String terminalEndpoint){
        return this.buildRequest(terminalEndpoint,null);
    }

    <T> ApiResponse<T> makeRequest(String terminalEndpoint, Map<? extends BaseParams,String> parameters, Class<T> someClass){
        try {
            HttpGet request = buildRequest(terminalEndpoint,parameterAdapter(parameters));
            return client.execute(request, response -> {
                if(response.getStatusLine().getStatusCode() == 200){
                    Type collectionType = TypeToken.getParameterized(ApiResponse.class, someClass).getType();
                    Reader json = new InputStreamReader(response.getEntity().getContent());
                    ApiResponse<T> objResp = gson.fromJson(json, collectionType);
                    if(objResp.getErrors().size() > 0){
                        StringBuffer exepBuffer = new StringBuffer();
                        objResp.getErrors().forEach((key, value) -> exepBuffer.append(key).append(" ").append(value));
                        logger.error(exepBuffer);
                        throw new ApiError(exepBuffer.toString());
                    }
                    return objResp;
                }else if(response.getStatusLine().getStatusCode() == 204){
                    //TODO: Aggiungere gestione per errori 204
                    throw new RuntimeException("Errore 204");
                }else if(response.getStatusLine().getStatusCode() >= 400 && response.getStatusLine().getStatusCode() <= 500){
                    Reader json = new InputStreamReader(response.getEntity().getContent());
                    throw gson.fromJson(json, ApiError.class);
                }else{
                    logger.error(response.getEntity().getContent());
                    throw new ApiError("Request error - See logs for more info");
                }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * Metodo di utilità che permette di generare l'endpoint completo compreso di parametri qual'ora siano presenti e
     * inseriti all'interno di @param parameters
     * @param endpoint - Url standard di accesso all'api
     * @param terminalEndpoint - Sezione finale dell'endpoint caratteristica di ogni chiamata
     * @param parameters - Parametri da aggiungere alla chiamata
     * @return URI
     * new ApiResponce<CountriesParams>(){}.getClass()
     */
    private URI _URIMaker(String endpoint, String terminalEndpoint, Map<String,String> parameters) {
        _assertNotNullorEmpty(endpoint);
        try {
            URIBuilder uri = new URIBuilder(endpoint);

            if(_isNotNullorEmpty(terminalEndpoint)){
                uri.setPathSegments(terminalEndpoint);
            }
            if(_isNotNull(parameters)){
                List<NameValuePair> parameterForURI = new ArrayList<>();
                parameters.forEach((key, value) -> parameterForURI.add(new BasicNameValuePair(key,value)));
                uri.addParameters(parameterForURI);
            }
            return uri.build();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Metodo utile nella conversione dei parametri in ingresso per la richiesta con la formattazione richiesta
     * dall'implementazione di questa classe buildRequest
     */
    private Map<String,String> parameterAdapter(Map<? extends BaseParams,String> parameters){
        if(_isNull(parameters)){
            return new HashMap<>();
        }
        Map<String,String> mapToReturn = new HashMap<>();
        parameters.forEach((key, value) -> mapToReturn.put(key.getValue(),value));
        return mapToReturn;
    }

    public String getActiveEndpoint() {
        return activeEndpoint;
    }
}
