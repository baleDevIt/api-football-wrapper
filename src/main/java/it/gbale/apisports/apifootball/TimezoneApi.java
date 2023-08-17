package it.gbale.apisports.apifootball;

import static it.gbale.apisports.utils.Validation.*;

import it.gbale.apisports.apifootball.model.core.ApiResponse;

import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class TimezoneApi extends BaseApi{

    private static final String ENDPOINT = "timezone";

    private final RequestFactory requestFactory;

    public TimezoneApi(RequestFactory requestFactory) {
        _assertNotNull(requestFactory);
        this.requestFactory = requestFactory;
    }

    /**
     * Restituisce tutti i valori stringa rappresentati i Timezones disponibili.
     * Questo metodo effettua genera una richiesta api.
     * @return String.class
     */
    public List<String> getAll_withRequest(){
        ApiResponse<String> response = requestFactory.makeRequest(ENDPOINT, null, String.class);
        return response.getResponse();
    }

    /**
     * Restituisce la richiesta completa rappresentate i Timezones disponibili.
     * Questo metodo effettua genera una richiesta api.
     */
    public ApiResponse<String> getResponse(){
        return requestFactory.makeRequest(ENDPOINT, null, String.class);
    }

    /**
     * Il metodo utilità crea e restituisce le ZoneId derivanti dalle stringe generate dalla chiamata endpoint.
     * Ad oggi vengono restituite due stringhe che non sono presenti nelle ZoneId, se necessarie vanno gestite con gli
     * altri metodi.
     * Queste stringe sono:
     * - Antarctica/McMur
     * - Antarctica/Palmerantaga
     * Questo metodo effettua genera una richiesta api.
     */
    public List<ZoneId> getAllTimezone_withRequest(){
        ApiResponse<ZoneId> response = requestFactory.makeRequest(ENDPOINT, null, ZoneId.class);
        List<ZoneId> zoneIds = response.getResponse();
        zoneIds.removeIf(Objects::isNull);
        return zoneIds;
    }


    /**
     * Restituisce tutti i valori rappresentati ZoneId disponibili.
     * Questo metodo NON GENERA una richiesta api.
     */
    public List<ZoneId> getAllZoneIds() {
        Set<String> zoneIds = ZoneId.getAvailableZoneIds();
        List<ZoneId> allZoneIds = new ArrayList<>();

        for (String zoneId : zoneIds) {
            allZoneIds.add(ZoneId.of(zoneId));
        }

        return allZoneIds;
    }
}

