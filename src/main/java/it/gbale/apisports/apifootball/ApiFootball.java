package it.gbale.apisports.apifootball;

import java.util.HashMap;
import java.util.Map;


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

    public SeasonsApi seasonsApi(){
        if(instancePool.containsKey(SeasonsApi.class)){
            return (SeasonsApi)  instancePool.get(SeasonsApi.class);
        }
        else{
            SeasonsApi seasonsApi = new SeasonsApi(requestFactory);
            instancePool.put(SeasonsApi.class, seasonsApi);
            return seasonsApi;
        }
    }

    public LeaguesApi leaguesApi(){
        if(instancePool.containsKey(LeaguesApi.class)){
            return (LeaguesApi)  instancePool.get(LeaguesApi.class);
        }
        else{
            LeaguesApi leaguesApi = new LeaguesApi(requestFactory);
            instancePool.put(LeaguesApi.class, leaguesApi);
            return leaguesApi;
        }
    }

    public FixturesApi fixturesApi(){
        if(instancePool.containsKey(FixturesApi.class)){
            return (FixturesApi)  instancePool.get(FixturesApi.class);
        }
        else{
            FixturesApi fixturesApi = new FixturesApi(requestFactory);
            instancePool.put(FixturesApi.class, fixturesApi);
            return fixturesApi;
        }
    }

    public VenuesApi venuesApi(){
        if(instancePool.containsKey(VenuesApi.class)){
            return (VenuesApi) instancePool.get(VenuesApi.class);
        }
        else{
            VenuesApi venuesApi = new VenuesApi(requestFactory);
            instancePool.put(VenuesApi.class, venuesApi);
            return venuesApi;
        }
    }

}
