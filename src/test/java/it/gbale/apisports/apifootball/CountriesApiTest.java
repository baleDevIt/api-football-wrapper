package it.gbale.apisports.apifootball;

import it.gbale.apisports.apifootball.model.entity.Countries;
import it.gbale.apisports.apifootball.model.exception.InvalidParamsException;
import it.gbale.apisports.apifootball.model.parameterEnum.Alpha2Code;
import it.gbale.apisports.apifootball.model.parameterEnum.CountriesParams;
import it.gbale.apisports.apifootball.model.parameterEnum.LeaguesParams;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

//@Disabled
class CountriesApiTest {

    private static ApiFootball apiFootball;

    @BeforeAll
    static void setup() {
        apiFootball = new ApiFootball(SetupClass.getToken());
    }

    @Tag("ApiCall")
    @Test
    void getAllRequestSuccess(){
        List<Countries> countriesList =  apiFootball.countriesApi().getAll();
        assertNotNull(countriesList);
        assertTrue(countriesList.size() > 0);
        assertInstanceOf(Countries.class, countriesList.get(0));
    }

    @Tag("ApiCall")
    @Test
    void findCountriesRequestSuccess(){
        Map<CountriesParams, String> paramsStringMap = new HashMap<>();
        paramsStringMap.put(CountriesParams.CODE, Alpha2Code.IT.name());
        List<Countries> countriesList = null;
        try {
            countriesList = apiFootball.countriesApi().findCountries(paramsStringMap);
        } catch (InvalidParamsException e) {
            throw new RuntimeException(e);
        }
        assertNotNull(countriesList);
        assertTrue(countriesList.size() == 1);
        assertInstanceOf(Countries.class, countriesList.get(0));
    }

    @Tag("ApiCall")
    @Test
    void findCountriesRequestWithCodeParameterNotValid(){
        Map<CountriesParams, String> paramsStringMap = new HashMap<>();
        paramsStringMap.put(CountriesParams.CODE, "GG");
        List<Countries> countriesList = null;
        try {
            countriesList = apiFootball.countriesApi().findCountries(paramsStringMap);
        } catch (InvalidParamsException e) {
            throw new RuntimeException(e);
        }
        assertNotNull(countriesList);
        assertTrue(countriesList.size() == 0);
    }

    @Test
    void findCountriesRequestWithNotValidParams(){
        Map<LeaguesParams, String> paramsStringMap = new HashMap<>();
        paramsStringMap.put(LeaguesParams.ID, "GG");
        assertThrows(InvalidParamsException.class, () -> {
            apiFootball.countriesApi().findCountries(paramsStringMap);
        });
    }

    @Tag("ApiCall")
    @Test
    void findCountriesByNameRequestSuccess(){
        List<Countries> countriesList = apiFootball.countriesApi().findCountriesByName("Italy");
        assertNotNull(countriesList);
        assertTrue(countriesList.size() == 1);
        assertInstanceOf(Countries.class, countriesList.get(0));
    }

    @Test
    void findCountriesByNameRequestWithEmptyParams(){
        assertThrows(IllegalArgumentException.class, () -> {
            apiFootball.countriesApi().findCountriesByName("");
        });
    }

    @Test
    void findCountriesByNameRequestWithNullParams(){
        assertThrows(IllegalArgumentException.class, () -> {
            apiFootball.countriesApi().findCountriesByName(null);
        });
    }

    @Test
    void findCountriesByCodeRequestWithNullParams(){
        assertThrows(IllegalArgumentException.class, () -> {
            apiFootball.countriesApi().findCountriesByCode(null);
        });
    }

    @Test
    void findCountriesBySearchRequestWithNullParams(){
        assertThrows(IllegalArgumentException.class, () -> {
            apiFootball.countriesApi().findCountriesBySearch(null);
        });
    }
    @Test
    void findCountriesBySearchRequestWithEmptyParams(){
        assertThrows(IllegalArgumentException.class, () -> {
            apiFootball.countriesApi().findCountriesBySearch("");
        });
    }

}