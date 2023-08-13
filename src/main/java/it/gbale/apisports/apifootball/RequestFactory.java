package it.gbale.apisports.apifootball;

import static it.gbale.apisports.utils.Validation.*;

import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
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
    private Header headerToken;
    private final GsonBuilder gson;
    private String activeEndpoint;
    private final CloseableHttpClient client;





    protected RequestFactory(String activeToken, boolean isApiSportsEndpoint) {
        _assertNotNullorEmpty(activeToken);

        if(isApiSportsEndpoint){
            this.activeEndpoint = APISPORTS_URL;
        }else{
            this.activeEndpoint = RAPID_API_URL;
        }
        this.headerToken = new BasicHeader(RAPIDAPI_HEADER_KEY, activeToken);
        this.gson = new GsonBuilder();
        this.client = HttpClients.createDefault();
        logger.info("ActiveEndpoint is - " + this.activeEndpoint);
    }

    /**
     * Restituisce una richiesta preformattata per il terminalEndpoint specificato
     * https://v3.football.api-sports.io/[terminalEndpoint]
     * https://api-football-v1.p.rapidapi.com/v3/[terminalEndpoint]
     * @return
     */
    protected HttpGet buildRequest(String terminalEndpoint, Map<String,String> parameters){
        try {
            URI uri = _URIMaker(activeEndpoint,terminalEndpoint, parameters);
            HttpGet request = new HttpGet(uri);
            request.addHeader(V3_FOOTBALL_HOST_HEADER);
            request.addHeader(headerToken);
            logger.info(this.getClass().getName() + " - buildRequest - Create uri " + uri.toString());
            return request;
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    protected HttpGet buildRequest(String terminalEndpoint){
        return this.buildRequest(terminalEndpoint,null);
    }

    protected <T> ApiResponse<T> makeRequest(String terminalEndpoint, Map<? extends BaseParams,String> parameters, Class<T> someClass){
        try {
            HttpGet request = buildRequest(terminalEndpoint,parameterAdapter(parameters));
            return client.execute(request, response -> {
                StringBuilder sb = new StringBuilder("Make Request ").append(request.getMethod()).append(response.getStatusLine().getStatusCode()).append(request.getURI());
                logger.info(sb);
                if(_isNotNull(response) && response.getStatusLine().getStatusCode() == 200){
                    Type collectionType = TypeToken.getParameterized(ApiResponse.class, someClass).getType();
                    Reader json = new InputStreamReader(response.getEntity().getContent());
                    return gson.create().fromJson(json, collectionType);
                }else if(_isNotNull(response) && response.getStatusLine().getStatusCode() == 204){
                    //TODO: Aggiungere gestione per errori 204
                    throw new RuntimeException("Errore 204");
                }else if(_isNotNull(response) && response.getStatusLine().getStatusCode() >= 400 && response.getStatusLine().getStatusCode() <= 500){
                    Reader json = new InputStreamReader(response.getEntity().getContent());
                    throw gson.create().fromJson(json, ApiError.class);
                }else{
                    logger.error(response.getEntity().getContent());
                    throw new ApiError("Request error - See logs for more info");
                }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    };


    /**
     * Metodo di utilità che permette di generare l'endpoint completo compreso di parametri qual'ora siano presenti e
     * inseriti all'interno di @param parameters
     * @param endpoint - Url standard di accesso all'api
     * @param terminalEndpoint - Sezione finale dell'endpoint caratteristica di ogni chiamata
     * @param parameters - Parametri da aggiungere alla chiamata
     * @return URI
     * @throws URISyntaxException
     * new ApiResponce<CountriesParams>(){}.getClass()
     */
    private URI _URIMaker(String endpoint, String terminalEndpoint, Map<String,String> parameters) throws URISyntaxException {
        _assertNotNullorEmpty(endpoint);
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
    }

    /**
     * Metodo utile nella conversione dei parametri in ingresso per la richiesta con la formattazione richiesta
     * dall'implementazione di questa classe buildRequest
     * @param parameters
     * @return
     */
    private Map<String,String> parameterAdapter(Map<? extends BaseParams,String> parameters){
        if(_isNull(parameters)){
            return new HashMap<>();
        }
        Map<String,String> mapToReturn = new HashMap<>();
        parameters.forEach((key, value) -> mapToReturn.put(key.getValue(),value));
        return mapToReturn;
    }

}
