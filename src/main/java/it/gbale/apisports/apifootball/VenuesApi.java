package it.gbale.apisports.apifootball;

import it.gbale.apisports.apifootball.model.core.ApiResponse;
import it.gbale.apisports.apifootball.model.entity.Venue;
import it.gbale.apisports.apifootball.model.parameterEnum.VenuesParams;

import java.util.List;
import java.util.Map;

import static it.gbale.apisports.utils.Validation._assertNotNull;
import static it.gbale.apisports.utils.Validation._assertNotNullorEmpty;

public class VenuesApi extends BaseApi {

    private static final String ENDPOINT = "venues";

    private final RequestFactory requestFactory;

    public VenuesApi(RequestFactory requestFactory) {
        _assertNotNull(requestFactory);
        this.requestFactory = requestFactory;
    }

    public ApiResponse<Venue> findVenue(Map<VenuesParams, String> venuesParams){
        _assertNotNull(venuesParams);
        return requestFactory.makeRequest(ENDPOINT, venuesParams, Venue.class);
    }

    public List<Venue> findVenueById(Integer venueId){
        _assertNotNull(venueId);
        return requestFactory.makeRequest(ENDPOINT, Map.of(VenuesParams.ID, String.valueOf(venueId)), Venue.class).getResponse();
    }

    public List<Venue> findVenueByName(String venueName){
        _assertNotNullorEmpty(venueName);
        return requestFactory.makeRequest(ENDPOINT, Map.of(VenuesParams.NAME, venueName), Venue.class).getResponse();
    }

    public List<Venue> findVenueByCity(String venueCity){
        _assertNotNullorEmpty(venueCity);
        return requestFactory.makeRequest(ENDPOINT, Map.of(VenuesParams.CITY, venueCity), Venue.class).getResponse();
    }

    public List<Venue> findVenueByCountry(String venueCountry){
        _assertNotNullorEmpty(venueCountry);
        return requestFactory.makeRequest(ENDPOINT, Map.of(VenuesParams.COUNTRY, venueCountry), Venue.class).getResponse();
    }

    public List<Venue> searchVenue(String venue){
        _assertNotNullorEmpty(venue);
        return requestFactory.makeRequest(ENDPOINT, Map.of(VenuesParams.SEARCH, venue), Venue.class).getResponse();
    }

}
