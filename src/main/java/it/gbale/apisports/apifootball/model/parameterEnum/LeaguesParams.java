package it.gbale.apisports.apifootball.model.parameterEnum;

public enum LeaguesParams implements BaseParams {

    CURRENT;

    @Override
    public String getValue() {
        return this.name().toLowerCase();
    }
}
