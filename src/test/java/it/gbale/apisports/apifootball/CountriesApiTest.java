package it.gbale.apisports.apifootball;

import it.gbale.apisports.apifootball.model.core.ApiResponse;
import it.gbale.apisports.apifootball.model.entity.Country;
import it.gbale.apisports.apifootball.model.exception.InvalidParamsException;
import it.gbale.apisports.apifootball.model.parameterEnum.CountryCode;
import it.gbale.apisports.apifootball.model.parameterEnum.CountriesParams;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CountriesApiTest {

    private static ApiFootball apiFootball;

    @BeforeAll
    static void setup() {
        apiFootball = new ApiFootball(System.getenv("SERVICETOKEN"));
    }

    @Tag("ApiCall")
    @Test
    void getAllRequestSuccess(){
        List<Country> countriesList =  apiFootball.countriesApi().getAll();
        assertNotNull(countriesList);
        assertTrue(countriesList.size() > 0);
        assertInstanceOf(Country.class, countriesList.get(0));
    }

    @Tag("ApiCall")
    @Test
    void findCountriesRequestSuccess(){
        List<Country> countriesList;
        Map<CountriesParams, String> paramsStringMap = new HashMap<>();
        paramsStringMap.put(CountriesParams.CODE, CountryCode.IT.name());
        try {
            countriesList = apiFootball.countriesApi().findCountries(paramsStringMap);
        } catch (InvalidParamsException e) {
            throw new RuntimeException(e);
        }
        assertNotNull(countriesList);
        assertEquals(countriesList.size(),1);
        assertInstanceOf(Country.class, countriesList.get(0));
    }

    @Tag("ApiCall")
    @Test
    void findCountriesRequestWithCodeParameterNotValid(){
        List<Country> countriesList;
        Map<CountriesParams, String> paramsStringMap = new HashMap<>();
        paramsStringMap.put(CountriesParams.CODE, "GG");
        try {
            countriesList = apiFootball.countriesApi().findCountries(paramsStringMap);
        } catch (InvalidParamsException e) {
            throw new RuntimeException(e);
        }
        assertNotNull(countriesList);
        assertEquals(countriesList.size(),0);
    }


    @Tag("ApiCall")
    @Test
    void findCountriesByNameRequestSuccess(){
        List<Country> countriesList = apiFootball.countriesApi().findCountriesByName("Italy");
        assertNotNull(countriesList);
        assertEquals(countriesList.size(),1);
        assertInstanceOf(Country.class, countriesList.get(0));
    }

    @Test
    void findCountriesByNameRequestWithEmptyParams(){
        assertThrows(IllegalArgumentException.class, () -> apiFootball.countriesApi().findCountriesByName(""));
    }

    @Test
    void findCountriesByNameRequestWithNullParams(){
        assertThrows(IllegalArgumentException.class, () -> apiFootball.countriesApi().findCountriesByName(null));
    }

    @Test
    void findCountriesByCodeRequestWithNullParams(){
        assertThrows(IllegalArgumentException.class, () -> apiFootball.countriesApi().findCountriesByCode(null));
    }

    @Test
    void findCountriesBySearchRequestWithNullParams(){
        assertThrows(IllegalArgumentException.class, () -> apiFootball.countriesApi().findCountriesBySearch(null));
    }
    @Test
    void findCountriesBySearchRequestWithEmptyParams(){
        assertThrows(IllegalArgumentException.class, () -> apiFootball.countriesApi().findCountriesBySearch(""));
    }

    @Tag("ApiCall")
    @Test
    void getResponseRequestSuccess(){
        ApiResponse<Country> response =  apiFootball.countriesApi().getResponse();
        assertNotNull(response);
        assertNotEquals(response.getResponse().size(),0);
        assertEquals(response.getErrors().size(),0);
        response.getResponse().forEach(value -> assertInstanceOf(Country.class, value));
    }

}
