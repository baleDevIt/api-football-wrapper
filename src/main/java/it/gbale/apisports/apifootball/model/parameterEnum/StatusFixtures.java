package it.gbale.apisports.apifootball.model.parameterEnum;

/**
 * Status of Fixtures
 * Fixtures with the status TBD may indicate an incorrect fixture date or time because the fixture date or time is not yet known or final.
 * Fixtures with this status are checked and updated daily. The same applies to fixtures with the status PST, CANC.
 * Call getKey() for string key of status
 */
@SuppressWarnings("unused")
public enum StatusFixtures {

    ToBeDefined("TBD"),
    NotStarted("NS"),
    FirstHalf("1H"),
    HalfTime("2H"),
    ExtraTime("ET"),
    BreakTime("BT"),
    PenaltyInProgress("P"),
    MatchSuspended("SUSP"),
    MatchInterrupted("INT"),
    MatchFinishedRegularTime("FT"),
    MatchFinishedAfterExtraTime("AET"),
    MatchFinishedAfterPenaltyShootout("PEN"),
    MatchCancelled("CANC"),
    MatchAbandoned("ABD"),
    TechnicalLoss("AWD"),
    WalkOver("WO"),
    InProgress("LIVE");


    private final String key;

    StatusFixtures(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}
