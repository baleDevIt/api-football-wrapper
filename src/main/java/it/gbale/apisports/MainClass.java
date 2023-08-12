package it.gbale.apisports;

import it.gbale.apisports.apifootball.ApiFootball;
import it.gbale.apisports.apifootball.model.parameterEnum.CountriesParams;

import java.util.HashMap;
import java.util.Map;

public class MainClass {

    public static void main(String[] args) {
        ApiFootball fot = new ApiFootball("331ab6beb624676035c0b23cb8de7e18");
        Map<CountriesParams, String> test = new HashMap<>();
        test.put(CountriesParams.CODE, "IT");
        test.put(CountriesParams.NAME, "Italy");
        fot.countriesApi().getCountries(test).forEach(System.out::println);
    }
}
