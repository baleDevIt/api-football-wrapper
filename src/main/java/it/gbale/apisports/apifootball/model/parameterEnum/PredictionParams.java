package it.gbale.apisports.apifootball.model.parameterEnum;

public enum PredictionParams implements BaseParams {
    FIXTURE;

    @Override
    public String getValue() {
        return this.name().toLowerCase();
    }
}
