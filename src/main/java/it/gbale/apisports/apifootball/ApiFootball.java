package it.gbale.apisports.apifootball;

import static it.gbale.apisports.utils.Validation.*;

/**
 * Wrapper entry class for Football Api
 * Official request documentation {@URL https://www.api-football.com/documentation-v3}
 */
public class ApiFootball extends BaseApi {

    private final RequestFactory requestFactory;

    //TODO: Raccolta di instanze gestite in questa classe


    /**
     * Costruttore della Wrapper entry class ApiSports.
     * Permette di impostare il token di autenticazione al servizio e l'endpoint base a cui effettuare le chiamate.
     * Se @param isApiSportsEndpoint è true questo costruttore imposta automaticamente l'endpoint {@URL https://v3.football.api-sports.io/}
     * altrimenti l'endpoint utilizzato nelle chiamate sarà {@URL https://api-football-v1.p.rapidapi.com/v3/}
     *
     * @param token
     * @param isApiSportsEndpoint
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
     * Di default questo costruttore imposta automaticamente l'endpoint {@URL https://v3.football.api-sports.io/}
     *
     * @param token
     */
    public ApiFootball(String token) {
        this(token,true);
    }

    public CountriesApi countriesApi(){
        //TODO: Aggiungere gestione delle istanze
        return new CountriesApi(requestFactory);
    }

}
