package it.gbale.apisports.apifootball;

import java.util.HashMap;
import java.util.Map;

import static it.gbale.apisports.utils.Validation.*;

/**
 * Wrapper entry class for Football Api
 */
public class ApiFootball {

    private final RequestFactory requestFactory;

    private final Map<Class<?>, BaseApi> instancePool = new HashMap<>();

    /**
     * Costruttore della Wrapper entry class ApiSports.
     * Permette di impostare il token di autenticazione al servizio e l'endpoint base a cui effettuare le chiamate.
     * Se @param isApiSportsEndpoint è true questo costruttore imposta automaticamente l'endpoint @see <a href="https://v3.football.api-sports.io/">v3.football.api-sports.io</a>
     * altrimenti l'endpoint utilizzato nelle chiamate sarà @see <a href="https://api-football-v1.p.rapidapi.com/v3/">api-football-v1.p.rapidapi.com</a>
     */
    public ApiFootball(String token, boolean isApiSportsEndpoint) {
        _assertNotNullorEmpty(token);
        if(isApiSportsEndpoint){
            this.requestFactory = new RequestFactory(token, true);
        }else{
            this.requestFactory = new RequestFactory(token, false);
        }
    }

    /**
     * Costruttore della Wrapper entry class ApiSports.
     * Permette di impostare il token di autenticazione al servizio e l'endpoint base a cui effettuare le chiamate.
     * Di default questo costruttore imposta automaticamente l'endpoint @see <a href="https://v3.football.api-sports.io/">v3.football.api-sports.io</a>
     */
    public ApiFootball(String token) {
        this(token,true);
    }

    public CountriesApi countriesApi(){
        if(instancePool.containsKey(CountriesApi.class)){
            return (CountriesApi)  instancePool.get(CountriesApi.class);
        }
        else{
            CountriesApi countriesApi = new CountriesApi(requestFactory);
            instancePool.put(CountriesApi.class, countriesApi);
            return countriesApi;
        }
    }

    public TimezoneApi timezoneApi(){
        if(instancePool.containsKey(TimezoneApi.class)){
            return (TimezoneApi)  instancePool.get(TimezoneApi.class);
        }
        else{
            TimezoneApi timezoneApi = new TimezoneApi(requestFactory);
            instancePool.put(TimezoneApi.class, timezoneApi);
            return timezoneApi;
        }
    }

}
