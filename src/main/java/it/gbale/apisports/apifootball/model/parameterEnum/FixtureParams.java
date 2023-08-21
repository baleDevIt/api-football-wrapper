package it.gbale.apisports.apifootball.model.parameterEnum;

@SuppressWarnings("unused")
public enum FixtureParams implements BaseParams {
    ID, IDS, LIVE, DATE, LEAGUE, SEASON, TEAM, LAST, NEXT, FROM, TO, ROUND, STATUS, VENUE, TIMEZONE;

    @Override
    public String getValue() {
        return this.name().toLowerCase();
    }
}