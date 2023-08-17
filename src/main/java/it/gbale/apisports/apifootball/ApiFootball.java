package it.gbale.apisports.apifootball;

import static it.gbale.apisports.utils.Validation.*;

/**
 * Wrapper entry class for Football Api
 */
public class ApiFootball extends BaseApi {

    private final RequestFactory requestFactory;

    //TODO: Raccolta di instanze gestite in questa classe


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
        //TODO: Aggiungere gestione delle istanze
        return new CountriesApi(requestFactory);
    }

    public TimezoneApi timezoneApi(){
        //TODO: Aggiungere gestione delle istanze
        return new TimezoneApi(requestFactory);
    }

}
