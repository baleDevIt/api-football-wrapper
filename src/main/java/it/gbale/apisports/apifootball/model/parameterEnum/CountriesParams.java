package it.gbale.apisports.apifootball.model.parameterEnum;

public enum CountriesParams implements BaseParams {
    NAME, CODE, SEARCH;

    @Override
    public String getValue() {
        return this.name().toLowerCase();
    }
}
