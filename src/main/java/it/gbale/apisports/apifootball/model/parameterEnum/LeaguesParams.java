package it.gbale.apisports.apifootball.model.parameterEnum;

/**
 * This class is a reference for key parameters of the LeagueApi calls.
 * ID -The id of the league [Integer]
 * NAME - The name of the league [String]
 * COUNTRY - The country name of the league [String]
 * CODE - The Alpha2 code of the country [CountryCode]
 * SEASON - The season year of the league [Integer]
 * TEAM - The id of the team [Integer]
 * TYPE - The type of the league [String - "league" or "cup"]
 * CURRENT - Return the list of active seasons or the last one of each competition [Boolean - "true" or "false"]
 * SEARCH - The name or the country of the league [String - >= 3 characters]
 * LAST - The X last leagues/cups added in the API [Integer - <= 2 characters]
 */
@SuppressWarnings("unused")
public enum LeaguesParams implements BaseParams {

    ID, NAME, COUNTRY, CODE, SEASON, TEAM, TYPE, CURRENT, SEARCH, LAST;

    @Override
    public String getValue() {
        return this.name().toLowerCase();
    }
}
