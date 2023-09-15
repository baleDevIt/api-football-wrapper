package it.gbale.apisports.apifootball.model.parameterEnum;

public enum VenuesParams implements BaseParams {
    ID, NAME, CITY, COUNTRY, SEARCH;

    @Override
    public String getValue() {
        return this.name().toLowerCase();
    }

}
